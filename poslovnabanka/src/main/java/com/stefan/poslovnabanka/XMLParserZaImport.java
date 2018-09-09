package com.stefan.poslovnabanka;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.stefan.poslovnabanka.model.AnalitikaIzvodaImport;


public class XMLParserZaImport {
	
	public static AnalitikaIzvodaImport readXML(File xml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(AnalitikaIzvodaImport.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Object object = unmarshaller.unmarshal(xml);
		AnalitikaIzvodaImport analitikaIzvodaImport = (AnalitikaIzvodaImport) object;
		
		analitikaIzvodaImport.setDatum_prijema(new Date());
		analitikaIzvodaImport.setDatum_valute(new Date());
		
		return analitikaIzvodaImport;
		
	}

}
