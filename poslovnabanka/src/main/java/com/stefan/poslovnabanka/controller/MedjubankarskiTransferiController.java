package com.stefan.poslovnabanka.controller;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.poslovnabanka.ExportNalogaZaMedjubankarskiTransferUXML;
import com.stefan.poslovnabanka.model.AnalitikaIzvoda;
import com.stefan.poslovnabanka.model.MedjubankarskiTransfer;
import com.stefan.poslovnabanka.service.AnalitikaIzvodaService;
import com.stefan.poslovnabanka.service.MedjubankarskiTransferiService;

@CrossOrigin
@RestController
@RequestMapping("/mbt")
public class MedjubankarskiTransferiController {

	@Autowired
	MedjubankarskiTransferiService medjubankarskiTransferiService;
	
	@Autowired
	AnalitikaIzvodaService analitikaIzvodaService;
	
	@RequestMapping("/dobavi")
	public ResponseEntity<List<MedjubankarskiTransfer>> dobaviSve()
	{
		return new ResponseEntity<List<MedjubankarskiTransfer>>(medjubankarskiTransferiService.pronadjiSve(),HttpStatus.OK);
	}
	
	@RequestMapping("/generisi")
	public ResponseEntity<List<MedjubankarskiTransfer>> generisiXML(@RequestBody MedjubankarskiTransfer medjubankarskiTransfer) throws ParserConfigurationException, TransformerException
	{
		Double iznos = 0d;
    	for(AnalitikaIzvoda a: analitikaIzvodaService.pronadjiSveSaIstimMedjuBankarskimTransferom(medjubankarskiTransfer.getId())) {
    		iznos = iznos+a.getIznos();
    		System.out.println("usao");
    	}
    	System.out.println(medjubankarskiTransfer.getId());
    	System.out.println(analitikaIzvodaService.pronadjiSveSaIstimMedjuBankarskimTransferom(medjubankarskiTransfer.getId()).size());
    	ExportNalogaZaMedjubankarskiTransferUXML.kreiranjeXMLDokumenta(analitikaIzvodaService.pronadjiSveSaIstimMedjuBankarskimTransferom(medjubankarskiTransfer.getId()),medjubankarskiTransferiService.pronadjiPoId(medjubankarskiTransfer.getId()), String.valueOf(iznos));
        
		return new ResponseEntity<List<MedjubankarskiTransfer>>(medjubankarskiTransferiService.pronadjiSve(),HttpStatus.OK);
	}
}
