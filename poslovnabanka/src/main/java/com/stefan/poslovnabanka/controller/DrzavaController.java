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
import com.stefan.poslovnabanka.service.DrzavaService;

@CrossOrigin
@RestController
@RequestMapping("/drzava")
public class DrzavaController {

	@Autowired
	DrzavaService drzavaService;
	
	@RequestMapping("/sacuvaj")
	public ResponseEntity<Drzava> sacuvajDrzavu(@Valid @RequestBody Drzava drzava)
	{
		drzavaService.sacuvajDrzavu(drzava);
		
		return new ResponseEntity<>(drzava,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<Drzava>> dobaviDrzave()
	{
		return new ResponseEntity<List<Drzava>>(drzavaService.dobaviSve(),HttpStatus.ACCEPTED);
	}
}
