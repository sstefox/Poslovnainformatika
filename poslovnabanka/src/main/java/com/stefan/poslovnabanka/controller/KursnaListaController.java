package com.stefan.poslovnabanka.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.poslovnabanka.model.KursnaLista;
import com.stefan.poslovnabanka.service.KursnaListaService;

@CrossOrigin
@RestController
@RequestMapping("/kursnaLista")
public class KursnaListaController {

	
	@Autowired
	KursnaListaService kursnaListaService;
	
	@RequestMapping("/sacuvaj")
	public ResponseEntity<KursnaLista> sacuvaj(@Valid @RequestBody KursnaLista kursnaLista){
		
		kursnaListaService.sacuvaj(kursnaLista);
		
		return new ResponseEntity<>(kursnaLista,HttpStatus.ACCEPTED);
	}
	
}
