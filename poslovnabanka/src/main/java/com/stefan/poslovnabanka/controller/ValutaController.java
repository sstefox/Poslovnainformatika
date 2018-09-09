package com.stefan.poslovnabanka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.poslovnabanka.model.Drzava;
import com.stefan.poslovnabanka.model.Valuta;
import com.stefan.poslovnabanka.service.DrzavaService;
import com.stefan.poslovnabanka.service.ValutaService;

@CrossOrigin
@RestController
@RequestMapping("/valuta")
public class ValutaController {
	
	@Autowired
	ValutaService valutaService;
	
	@Autowired
	DrzavaService drzavaService;
	
	@RequestMapping("/sacuvaj")
	public ResponseEntity<Valuta> sacuvaj(@Valid @RequestBody Valuta valuta)
	{
		valutaService.sacuvaj(valuta);
		
		return new ResponseEntity<Valuta>(valuta,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<Valuta>> dobaviValute()
	{
		return new ResponseEntity<List<Valuta>>(valutaService.dobaviSve(),HttpStatus.ACCEPTED);
	}

}
