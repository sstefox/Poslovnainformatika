package com.stefan.poslovnabanka.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;
import com.stefan.poslovnabanka.model.RacuniPravnihLica;
import com.stefan.poslovnabanka.model.Ukidanje;
import com.stefan.poslovnabanka.service.DnevnoStanjeRacunaService;
import com.stefan.poslovnabanka.service.RacuniPravnihLicaService;
import com.stefan.poslovnabanka.service.UkidanjeService;

@CrossOrigin
@RestController
@RequestMapping("/ukidanje")
public class UkidanjeController {

	@Autowired
	UkidanjeService ukidanjeService;
	
	@Autowired
	RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	@RequestMapping("/izvrsi")
	public ResponseEntity<Ukidanje> izvrsiUkidanje(@Valid @RequestBody Ukidanje ukidanje)
	{
		ukidanjeService.izvrsiUkidanje(ukidanje);
		racuniPravnihLicaService.ukidanjeRacuna(ukidanje.getUkidanjeRacuna());
		DnevnoStanjeRacuna dnevnoStanjeRacunaZaUkidanje = dnevnoStanjeRacunaService.dobaviPoslednjeStanjeZaKlijenta(ukidanje.getUkidanjeRacuna().getId());
		
		if(ukidanje.getSredstva_se_prenose_na_racun() !=null)
		{
			RacuniPravnihLica racuniPravnihLica = racuniPravnihLicaService.dobaviJedanRacun(ukidanje.getSredstva_se_prenose_na_racun());
			DnevnoStanjeRacuna dnevnoStanjeRacuna = dnevnoStanjeRacunaService.dobaviPoslednjeStanjeZaKlijenta(racuniPravnihLica.getId());
			DnevnoStanjeRacuna dRacuna = new DnevnoStanjeRacuna();
			dRacuna.setRacuniPravnihLica(racuniPravnihLica);
			dRacuna.setDatum_prometa(new Date());
			dRacuna.setBroj_izvoda(dnevnoStanjeRacuna.getBroj_izvoda()+1);
			dRacuna.setPrethodno_stanje(dnevnoStanjeRacuna.getNovo_stanje());
			dRacuna.setPromet_na_teret(0d);
			dRacuna.setPromet_u_korist(dnevnoStanjeRacunaZaUkidanje.getNovo_stanje());
			dRacuna.setNovo_stanje(dnevnoStanjeRacuna.getNovo_stanje()+dnevnoStanjeRacunaZaUkidanje.getNovo_stanje());
			
			dnevnoStanjeRacunaService.upisStanja(dRacuna);
		}
		
		return new ResponseEntity<Ukidanje>(ukidanje,HttpStatus.ACCEPTED);
	}
}
