package com.stefan.poslovnabanka.controller;

import java.util.Date;
import java.util.List;

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
import com.stefan.poslovnabanka.service.DnevnoStanjeRacunaService;
import com.stefan.poslovnabanka.service.RacuniPravnihLicaService;

@CrossOrigin
@RestController
@RequestMapping("/racuniPravnihLica")
public class RacuniPravnihLicaController {

	
	@Autowired
	RacuniPravnihLicaService racuniPravnihLicaService;
	
	@Autowired
	DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	@RequestMapping("/sacuvaj")
	public ResponseEntity<RacuniPravnihLica> sacuvaj(@Valid @RequestBody RacuniPravnihLica racuniPravnihLica)
	{
		racuniPravnihLica.setVazeci(true);
		racuniPravnihLica.setBroj_racuna("00"+racuniPravnihLica.getPoslovna_banka().getId()+"-"+racuniPravnihLica.getBroj_racuna());
		racuniPravnihLicaService.sacuvaj(racuniPravnihLica);
		
		racuniPravnihLica = racuniPravnihLicaService.dobaviSveVazece().get(racuniPravnihLicaService.dobaviSveVazece().size()-1);
		
		DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		if(dnevnoStanjeRacunaService.dobaviSve().size()==0)
		{
			dnevnoStanjeRacuna.setBroj_izvoda(0);
		} else {
			dnevnoStanjeRacuna.setBroj_izvoda(dnevnoStanjeRacunaService.dobaviSve().get(dnevnoStanjeRacunaService.dobaviSve().size()-1).getBroj_izvoda()+1);
		}
		
		dnevnoStanjeRacuna.setDatum_prometa(new Date());
		dnevnoStanjeRacuna.setNovo_stanje(0d);
		dnevnoStanjeRacuna.setPrethodno_stanje(0d);
		dnevnoStanjeRacuna.setPromet_na_teret(0d);
		dnevnoStanjeRacuna.setPromet_u_korist(0d);
		dnevnoStanjeRacuna.setRacuniPravnihLica(racuniPravnihLica);
		
		dnevnoStanjeRacunaService.upisStanja(dnevnoStanjeRacuna);
		
		return new ResponseEntity<RacuniPravnihLica>(racuniPravnihLica,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<RacuniPravnihLica>> dobaviSveVazece()
	{	
		return new ResponseEntity<List<RacuniPravnihLica>>(racuniPravnihLicaService.dobaviSveVazece(),HttpStatus.ACCEPTED);
	}
}
