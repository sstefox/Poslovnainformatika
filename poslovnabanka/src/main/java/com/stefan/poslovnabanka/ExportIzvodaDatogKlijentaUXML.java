package com.stefan.poslovnabanka;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;
import com.stefan.poslovnabanka.model.RacuniPravnihLica;

public class ExportIzvodaDatogKlijentaUXML {

	
	public static void kreiranjeXMLDokumenta(List<DnevnoStanjeRacuna> dnevnoStanjeRacunaList, RacuniPravnihLica racunPravnogLica) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		
		Document document = documentBuilder.newDocument();
		Element osnovniTag = document.createElement("IZVOD");
		osnovniTag.setAttribute("datum", dateToStr(new Date()));	
		document.appendChild(osnovniTag);
		
		Element opsti_podaci = document.createElement("opsti-podaci");
		
		Element sifraBanke = document.createElement("sifra-banke");
		sifraBanke.setTextContent(racunPravnogLica.getPoslovna_banka().getSifra_banke());
		opsti_podaci.appendChild(sifraBanke);
				
		Element brojRacuna = document.createElement("broj-racuna");
		brojRacuna.setTextContent(racunPravnogLica.getBroj_racuna());
		opsti_podaci.appendChild(brojRacuna);
				
		Element valuta = document.createElement("valuta");
		valuta.setTextContent(racunPravnogLica.getValuta().getZvanicna_sifra());
		opsti_podaci.appendChild(valuta);
				
		Element klijent = document.createElement("klijent");
		klijent.setTextContent(racunPravnogLica.getVlasnik_racuna().getNaziv_klijenta());
		opsti_podaci.appendChild(klijent);
				
		Element prethodnoStanjePeriod = document.createElement("prethodno-stanje-za-period");
		prethodnoStanjePeriod.setTextContent(dnevnoStanjeRacunaList.get(0).getPrethodno_stanje().toString());
		opsti_podaci.appendChild(prethodnoStanjePeriod);
				
		Element novoStanjePeriod = document.createElement("novo-stanje-za-period");
		novoStanjePeriod.setTextContent(dnevnoStanjeRacunaList.get(dnevnoStanjeRacunaList.size()-1).getNovo_stanje().toString());
		opsti_podaci.appendChild(novoStanjePeriod);
				
		osnovniTag.appendChild(opsti_podaci);
			
		Element listaTag = document.createElement("lista_dnevnih_stanja");
		
		for (DnevnoStanjeRacuna dsr : dnevnoStanjeRacunaList){
				Element dnevnoStanje = document.createElement("promet_na_dan");
				
				Element datum = document.createElement("datum");
				datum.setTextContent(dateToStr(dsr.getDatum_prometa()));
				dnevnoStanje.appendChild(datum);
			
				Element prethodnoStanje = document.createElement("prethodno-stanje");
				prethodnoStanje.setTextContent(dsr.getPrethodno_stanje().toString());
				dnevnoStanje.appendChild(prethodnoStanje);
			
				Element uKorist = document.createElement("promet-u-korist");
				uKorist.setTextContent(dsr.getPromet_u_korist().toString());
				dnevnoStanje.appendChild(uKorist);
			
				Element naTeret = document.createElement("promet-na-teret");
				naTeret.setTextContent(dsr.getPromet_na_teret().toString());
				dnevnoStanje.appendChild(naTeret);
			
				Element novoStanje = document.createElement("novo-stanje");
				novoStanje.setTextContent(dsr.getNovo_stanje().toString());
				dnevnoStanje.appendChild(novoStanje);
			
				listaTag.appendChild(dnevnoStanje);
		}
		
		osnovniTag.appendChild(listaTag);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource src = new DOMSource(document);
		StreamResult result = new StreamResult(new File("./exported/izvod_datog_klijenta.xml"));
				
		t.transform(src, result);
		
	}
	
	private static String dateToStr(Date d){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");		
		return df.format(d);
	}

}
