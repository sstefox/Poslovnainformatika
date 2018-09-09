package com.stefan.poslovnabanka.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefan.poslovnabanka.jasper.IzvodKlijentaDataSource;
import com.stefan.poslovnabanka.jasper.Reporti;
import com.stefan.poslovnabanka.jasper.SpisakRacunaDataSource;
import com.stefan.poslovnabanka.model.Banka;
import com.stefan.poslovnabanka.repository.BankaRepository;
import com.stefan.poslovnabanka.repository.DnevnoStanjeRacunaRepository;
import com.stefan.poslovnabanka.repository.RacuniPravnihLicaRepository;
import com.stefan.poslovnabanka.service.BankaService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin
@RestController
@RequestMapping("/banka")
public class BankaController {
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	DnevnoStanjeRacunaRepository dnevnoStanjeRacunaRepository;
	
	@Autowired
	BankaRepository bankaRepository;
	
	@Autowired
	RacuniPravnihLicaRepository racuniPravnihLicaRepository;
	
	@RequestMapping("/sacuvaj")
	public ResponseEntity<Banka> sacuvajBanku(@Valid @RequestBody Banka banka){
		System.out.println(banka.getPib());
		bankaService.sacuvajBanku(banka);
		
		return new ResponseEntity<>(banka,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<Banka>> dobaviSve() throws JsonProcessingException{
		return new ResponseEntity<>(bankaService.dobaviSve(),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/generisiXML/{id}")
	public ResponseEntity<List<Banka>> generisiXML(@PathVariable Integer id) throws JsonProcessingException, JRException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		Map parametri = new HashMap<>();
		System.out.println(id);
        SpisakRacunaDataSource s = new SpisakRacunaDataSource(dnevnoStanjeRacunaRepository, id,bankaRepository,racuniPravnihLicaRepository);
		JRDataSource jrDatasource = s.create(null);
		Reporti iz  = new Reporti();
    	iz.spisakRacunaJasper(parametri, jrDatasource);
		return new ResponseEntity<>(bankaService.dobaviSve(),HttpStatus.ACCEPTED);
	}

}
