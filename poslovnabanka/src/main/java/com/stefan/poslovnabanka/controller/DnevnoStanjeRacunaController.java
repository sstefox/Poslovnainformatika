package com.stefan.poslovnabanka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;
import com.stefan.poslovnabanka.service.DnevnoStanjeRacunaService;

@CrossOrigin
@RestController
@RequestMapping("/dnevnoStanje")
public class DnevnoStanjeRacunaController {
	
	@Autowired
	DnevnoStanjeRacunaService dnevnoStanjeRacunaService;
	
	

	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<DnevnoStanjeRacuna>> dobaviSve()
	{
		return new ResponseEntity<List<DnevnoStanjeRacuna>>(dnevnoStanjeRacunaService.dobaviSve(),HttpStatus.ACCEPTED);
	}
}
