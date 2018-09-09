package com.stefan.poslovnabanka.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stefan.poslovnabanka.XMLParserZaImport;
import com.stefan.poslovnabanka.model.AnalitikaIzvoda;
import com.stefan.poslovnabanka.model.AnalitikaIzvodaImport;
import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;
import com.stefan.poslovnabanka.model.MedjubankarskiTransfer;
import com.stefan.poslovnabanka.model.RacuniPravnihLica;
import com.stefan.poslovnabanka.service.AnalitikaIzvodaService;
import com.stefan.poslovnabanka.service.BankaService;
import com.stefan.poslovnabanka.service.DnevnoStanjeRacunaService;
import com.stefan.poslovnabanka.service.MedjubankarskiTransferiService;
import com.stefan.poslovnabanka.service.RacuniPravnihLicaService;
import com.stefan.poslovnabanka.service.ValutaService;

@CrossOrigin
@RestController
@RequestMapping("/analitika")
public class AnalitikaIzvodaController {

	@Autowired
	AnalitikaIzvodaService analitikaIzvodaService;
	
	@Autowired
	RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	MedjubankarskiTransferiService medjubankarskiTransferiService;
	
	@Autowired
	ValutaService valutaService;
	
	@RequestMapping("/uplata")
	public ResponseEntity<AnalitikaIzvoda> uplata(@Valid @RequestBody AnalitikaIzvoda analitikaIzvoda)
	{
		
		boolean signalUplate = false;
		if(analitikaIzvoda.getRacun_duznika().length()>3)
		{
			String banka1= analitikaIzvoda.getRacun_duznika().substring(0, Math.min(analitikaIzvoda.getRacun_duznika().length(), 3));
			String banka2= analitikaIzvoda.getRacun_poverioca().substring(0, Math.min(analitikaIzvoda.getRacun_poverioca().length(), 3));
			
			if(banka1.equals(banka2)) {
				izvrsiRTGS(analitikaIzvoda);
				analitikaIzvoda.setStatus(true);
				signalUplate = true;
			} else {
				MedjubankarskiTransfer medjubankarskiTransfer = new MedjubankarskiTransfer();
				medjubankarskiTransfer.setBankaPosiljalac(bankaService.pronadjiJednuPoRacunu(banka1));
				medjubankarskiTransfer.setBankaPrimalac(bankaService.pronadjiJednuPoRacunu(banka2));
				medjubankarskiTransfer.setDatum(new Date());
				
				medjubankarskiTransferiService.sacuvaj(medjubankarskiTransfer);
				analitikaIzvoda.setMedjubankarskiTransfer(medjubankarskiTransferiService.pronadjiPosljednjiUpisan());
			}
		}
		
		if(analitikaIzvoda.isHitno() || analitikaIzvoda.getIznos()>=250000 || !signalUplate) {
			izvrsiRTGS(analitikaIzvoda);
			analitikaIzvoda.setStatus(true);
		}
		
		analitikaIzvodaService.uplata(analitikaIzvoda);
		
		return new ResponseEntity<AnalitikaIzvoda>(analitikaIzvoda,HttpStatus.ACCEPTED); 
	}
	
	@RequestMapping("/izvrsiKliring")
	public ResponseEntity<AnalitikaIzvoda> izvrsiKliring()
	{
		for(AnalitikaIzvoda a:analitikaIzvodaService.pronadjiSveNeizvrsene())
		{
			izvrsiRTGS(a);
			a.setStatus(true);
			
			if(a.getRacun_duznika().length()>3)
			{
				String banka1= a.getRacun_duznika().substring(0, Math.min(a.getRacun_duznika().length(), 3));
				String banka2= a.getRacun_poverioca().substring(0, Math.min(a.getRacun_poverioca().length(), 3));
				
				if(!banka1.equals(banka2)) {
					MedjubankarskiTransfer medjubankarskiTransfer = new MedjubankarskiTransfer();
					medjubankarskiTransfer.setBankaPosiljalac(bankaService.pronadjiJednuPoRacunu(banka1));
					medjubankarskiTransfer.setBankaPrimalac(bankaService.pronadjiJednuPoRacunu(banka2));
					medjubankarskiTransfer.setDatum(new Date());
					
					medjubankarskiTransferiService.sacuvaj(medjubankarskiTransfer);
					a.setMedjubankarskiTransfer(medjubankarskiTransferiService.pronadjiPosljednjiUpisan());
				}
			}
			
			analitikaIzvodaService.uplata(a);
		}
		
		return new ResponseEntity<AnalitikaIzvoda>(new AnalitikaIzvoda(),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/uploadXML")
	public ResponseEntity<AnalitikaIzvodaImport> uploadXML(@RequestParam("file") MultipartFile file) throws IllegalStateException, JAXBException, IOException{
		
		AnalitikaIzvodaImport a = XMLParserZaImport.readXML(multipartToFile(file));
		AnalitikaIzvoda analitikaIzvoda = convert(a);
		if(a.getRacun_duznika().length()>3)
		{
			String banka1= a.getRacun_duznika().substring(0, Math.min(a.getRacun_duznika().length(), 3));
			String banka2= a.getRacun_poverioca().substring(0, Math.min(a.getRacun_poverioca().length(), 3));
			
			if(!banka1.equals(banka2)) {
				MedjubankarskiTransfer medjubankarskiTransfer = new MedjubankarskiTransfer();
				medjubankarskiTransfer.setBankaPosiljalac(bankaService.pronadjiJednuPoRacunu(banka1));
				medjubankarskiTransfer.setBankaPrimalac(bankaService.pronadjiJednuPoRacunu(banka2));
				medjubankarskiTransfer.setDatum(new Date());
				
				medjubankarskiTransferiService.sacuvaj(medjubankarskiTransfer);
				analitikaIzvoda.setMedjubankarskiTransfer(medjubankarskiTransferiService.pronadjiPosljednjiUpisan());
			}
		}
		
		if(analitikaIzvoda.isHitno() || analitikaIzvoda.getIznos()>=250000) {
			izvrsiRTGS(analitikaIzvoda);
			analitikaIzvoda.setStatus(true);
		}
		
		analitikaIzvodaService.uplata(analitikaIzvoda);
		
		return new ResponseEntity<AnalitikaIzvodaImport>(a,HttpStatus.ACCEPTED);
	}

	private void izvrsiRTGS(AnalitikaIzvoda analitikaIzvoda) {
		
		if(!analitikaIzvoda.getRacun_duznika().isEmpty())
		{
			RacuniPravnihLica racuniPravnihLica = racuniPravnihLicaService.dobaviJedanRacun(analitikaIzvoda.getRacun_duznika());
			DnevnoStanjeRacuna dnevnoStanjeRacuna = dnevnoStanjeRacunaService.dobaviPoslednjeStanjeZaKlijenta(racuniPravnihLica.getId());
			DnevnoStanjeRacuna dRacuna = new DnevnoStanjeRacuna();
			dRacuna.setRacuniPravnihLica(racuniPravnihLica);
			dRacuna.setDatum_prometa(new Date());
			dRacuna.setBroj_izvoda(dnevnoStanjeRacuna.getBroj_izvoda()+1);
			dRacuna.setPrethodno_stanje(dnevnoStanjeRacuna.getNovo_stanje());
			dRacuna.setPromet_na_teret(analitikaIzvoda.getIznos());
			dRacuna.setPromet_u_korist(0d);
			dRacuna.setNovo_stanje(dnevnoStanjeRacuna.getNovo_stanje()-analitikaIzvoda.getIznos());
			System.out.println(dRacuna.getNovo_stanje());
			System.out.println(dnevnoStanjeRacuna.getPrethodno_stanje());
			System.out.println("123");
			
			dnevnoStanjeRacunaService.upisStanja(dRacuna);
		}
		
		RacuniPravnihLica racuniPravnihLica = racuniPravnihLicaService.dobaviJedanRacun(analitikaIzvoda.getRacun_poverioca());
		DnevnoStanjeRacuna dnevnoStanjeRacuna = dnevnoStanjeRacunaService.dobaviPoslednjeStanjeZaKlijenta(racuniPravnihLica.getId());
		DnevnoStanjeRacuna dRacuna = new DnevnoStanjeRacuna();
		dRacuna.setRacuniPravnihLica(racuniPravnihLica);
		dRacuna.setDatum_prometa(new Date());
		dRacuna.setBroj_izvoda(dnevnoStanjeRacuna.getBroj_izvoda()+1);
		dRacuna.setPrethodno_stanje(dnevnoStanjeRacuna.getNovo_stanje());
		dRacuna.setPromet_na_teret(0d);
		dRacuna.setPromet_u_korist(analitikaIzvoda.getIznos());
		dRacuna.setNovo_stanje(dnevnoStanjeRacuna.getNovo_stanje()+analitikaIzvoda.getIznos());
		
		dnevnoStanjeRacunaService.upisStanja(dRacuna);
		
	}
	
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	    File convFile = new File( multipart.getOriginalFilename());
	    multipart.transferTo(convFile);
	    return convFile;
	}
	
	private AnalitikaIzvoda convert(AnalitikaIzvodaImport analitikaIzvodaImport)
	{
		AnalitikaIzvoda a = new AnalitikaIzvoda();
		
		a.setBroj_stavke(analitikaIzvodaImport.getBroj_stavke());
		a.setDatum_prijema(analitikaIzvodaImport.getDatum_prijema());
		a.setDuznik(analitikaIzvodaImport.getDuznik());
		a.setHitno(analitikaIzvodaImport.isHitno());
		a.setIznos(analitikaIzvodaImport.getIznos());
		a.setModel_odobrenja(analitikaIzvodaImport.getModel_odobrenja());
		a.setModel_zaduzenja(analitikaIzvodaImport.getModel_zaduzenja());
		a.setPoverilac(analitikaIzvodaImport.getPoverilac());
		a.setPoziv_na_broj_odobrenja(analitikaIzvodaImport.getPoziv_na_broj_odobrenja());
		a.setPoziv_na_broj_zaduzenja(analitikaIzvodaImport.getPoziv_na_broj_zaduzenja());
		a.setRacun_duznika(analitikaIzvodaImport.getRacun_duznika());
		a.setRacun_poverioca(analitikaIzvodaImport.getRacun_poverioca());
		a.setSvrha_placanja(analitikaIzvodaImport.getSvrha_placanja());
		a.setDatum_valute(new Date());
		a.setValuta(valutaService.dobaviValutuPoNazivu(analitikaIzvodaImport.getNaziv_valute()));
		
		return a;
	}
	
	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<AnalitikaIzvoda>> dobaviSve()
	{
		return new ResponseEntity<List<AnalitikaIzvoda>>(analitikaIzvodaService.pronadjiSve(),HttpStatus.ACCEPTED);
	}
}
