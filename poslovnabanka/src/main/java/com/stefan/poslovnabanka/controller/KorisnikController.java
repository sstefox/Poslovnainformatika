package com.stefan.poslovnabanka.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.poslovnabanka.jasper.IzvodKlijentaDataSource;
import com.stefan.poslovnabanka.jasper.Reporti;
import com.stefan.poslovnabanka.model.Klijent;
import com.stefan.poslovnabanka.model.KorisnikParametars;
import com.stefan.poslovnabanka.model.RacuniPravnihLica;
import com.stefan.poslovnabanka.model.Zaposleni;
import com.stefan.poslovnabanka.repository.AnalitikaIzvodaRepository;
import com.stefan.poslovnabanka.repository.BankaRepository;
import com.stefan.poslovnabanka.repository.KlijentRepository;
import com.stefan.poslovnabanka.service.AnalitikaIzvodaService;
import com.stefan.poslovnabanka.service.BankaService;
import com.stefan.poslovnabanka.service.DnevnoStanjeRacunaService;
import com.stefan.poslovnabanka.service.KlijentService;
import com.stefan.poslovnabanka.service.MedjubankarskiTransferiService;
import com.stefan.poslovnabanka.service.RacuniPravnihLicaService;
import com.stefan.poslovnabanka.service.ZaposleniService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

    @Autowired
    KlijentService klijentService;
    
    @Autowired
	AnalitikaIzvodaService analitikaIzvodaService;
	
	@Autowired
	ZaposleniService zaposleniService;
	
	@Autowired
	RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	BankaRepository bankaRepository;
	
	@Autowired
	MedjubankarskiTransferiService medjubankarskiTransferiService;
	
	@Autowired
	AnalitikaIzvodaRepository analitikaIzvodaRepository;

    @RequestMapping("/login")
    public ResponseEntity<KorisnikParametars> login(@RequestBody KorisnikParametars korisnikParametars){

        for(Zaposleni z:zaposleniService.dobaviSve())
        {
        	if(korisnikParametars.getEmail().equals(z.getEmail()) && korisnikParametars.getPassword().equals(z.getPassword())) {
        		return new ResponseEntity<>(korisnikParametars, HttpStatus.OK);
        	}
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody Zaposleni zaposleni){
        zaposleniService.save(zaposleni);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    
    @RequestMapping("/dobaviSve")
    public ResponseEntity<List<Klijent>> dobaviSve(){
        return new ResponseEntity<>(klijentService.dobaviSve(),HttpStatus.OK);
    }
    
    @RequestMapping("/generisi/{datum_od}/{datum_do}")
    public ResponseEntity<List<Klijent>> generisiPDF(@PathVariable String datum_od,@PathVariable String datum_do,@RequestBody RacuniPravnihLica racuniPravnihLica) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, JRException, ParseException{
        Map parametri = new HashMap<>();
        parametri.put("datum_od", datum_od);
        parametri.put("datum_do", datum_do);
        parametri.put("racun", racuniPravnihLica.getBroj_racuna());
        parametri.put("naziv",racuniPravnihLica.getVlasnik_racuna().getUsername());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(racuniPravnihLica.getBroj_racuna());
        IzvodKlijentaDataSource s = new IzvodKlijentaDataSource(analitikaIzvodaRepository,dateFormat.parse(datum_od),dateFormat.parse(datum_do),racuniPravnihLica.getBroj_racuna());
		JRDataSource jrDatasource = s.create(null);
		Reporti iz  = new Reporti();
    	iz.izvodKlijentaJasper(parametri,jrDatasource);
    	
    	return new ResponseEntity<>(klijentService.dobaviSve(),HttpStatus.OK);
    }
    
    

}
