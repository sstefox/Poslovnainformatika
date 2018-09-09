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

import com.stefan.poslovnabanka.model.NaseljenoMesto;
import com.stefan.poslovnabanka.model.Valuta;
import com.stefan.poslovnabanka.service.NaseljenoMestoService;

@CrossOrigin
@RestController
@RequestMapping("/naseljenoMesto")
public class NaseljenoMestoController {

	@Autowired
	NaseljenoMestoService naseljenoMestoService;
	
	@RequestMapping("/sacuvaj")
	public ResponseEntity<NaseljenoMesto> sacuvaj(@Valid @RequestBody NaseljenoMesto naseljenoMesto)
	{
		naseljenoMestoService.sacuvaj(naseljenoMesto);
		
		return new ResponseEntity<NaseljenoMesto>(naseljenoMesto,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/dobaviSve")
	public ResponseEntity<List<NaseljenoMesto>> dobaviMesta()
	{
		return new ResponseEntity<List<NaseljenoMesto>>(naseljenoMestoService.dobaviSve(),HttpStatus.ACCEPTED);
	}
}
