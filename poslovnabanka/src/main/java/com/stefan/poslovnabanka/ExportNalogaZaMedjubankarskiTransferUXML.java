package com.stefan.poslovnabanka;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.stefan.poslovnabanka.model.AnalitikaIzvoda;
import com.stefan.poslovnabanka.model.MedjubankarskiTransfer;

public class ExportNalogaZaMedjubankarskiTransferUXML {

	
	public static void kreiranjeXMLDokumenta(List<AnalitikaIzvoda> analitikeIzvoda ,MedjubankarskiTransfer medjubankarskiTransfer,String ukupanIznos) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("MEDJUBANKARSKI-TRANSFER");
		doc.appendChild(rootElement);
		
		Element zaglavlje = doc.createElement("OPSTI-PODACI");
		
		Element obracunRacBankeDuz = doc.createElement("naziv-banke-duznika");
		obracunRacBankeDuz.setTextContent(medjubankarskiTransfer.bankaPosiljalac.getNaziv());
		zaglavlje.appendChild(obracunRacBankeDuz);
		
		Element obracunRacBankePrim = doc.createElement("naziv-banke-poverioca");
		obracunRacBankePrim.setTextContent(medjubankarskiTransfer.bankaPrimalac.getNaziv());
		zaglavlje.appendChild(obracunRacBankePrim);
		
		Element ukupanPrenos = doc.createElement("ukupan-iznos-sredstava");
		ukupanPrenos.setTextContent(ukupanIznos.toString());
		zaglavlje.appendChild(ukupanPrenos);
		
		Element sifraValute = doc.createElement("naziv-valute");
		sifraValute.setTextContent(analitikeIzvoda.get(0).getValuta().getNaziv());
		zaglavlje.appendChild(sifraValute);
		
		Date datum = findLastDate(analitikeIzvoda);
		
		Element datumValute = doc.createElement("datum-valute");
		datumValute.setTextContent(datum.toString());
		zaglavlje.appendChild(datumValute);
		
		Element datumPrijema = doc.createElement("datum-prijema");
		datumPrijema.setTextContent(datum.toString());
		zaglavlje.appendChild(datumPrijema);		
		
		rootElement.appendChild(zaglavlje);
		
		Element naloziList = doc.createElement("izvrseni-transferi");
		
		for (AnalitikaIzvoda analitikaIzvoda : analitikeIzvoda){
			Element jedanNalog = doc.createElement("nalog");
			jedanNalog.setAttribute("broj_stavke", String.valueOf(analitikaIzvoda.getBroj_stavke()));
			
			Element duznik = doc.createElement("duznik");
			duznik.setTextContent(analitikaIzvoda.getDuznik());
			jedanNalog.appendChild(duznik);
			
			Element svrhaPlacanja = doc.createElement("svrha_placanja");
			svrhaPlacanja.setTextContent(analitikaIzvoda.getSvrha_placanja());
			jedanNalog.appendChild(svrhaPlacanja);
			
			Element poverilac = doc.createElement("poverilac");
			poverilac.setTextContent(analitikaIzvoda.getPoverilac());
			jedanNalog.appendChild(poverilac);
			
			Element datumNaloga = doc.createElement("datum_prijema");
			datumNaloga.setTextContent(analitikaIzvoda.getDatum_prijema().toString());
			jedanNalog.appendChild(datumNaloga);
			
			Element racunDuznika = doc.createElement("racun_duznika");
			racunDuznika.setTextContent(analitikaIzvoda.getRacun_duznika());
			jedanNalog.appendChild(racunDuznika);
			
			Element modelZaduzenja = doc.createElement("model_zaduzenja");
			modelZaduzenja.setTextContent(String.valueOf(analitikaIzvoda.getModel_zaduzenja()));
			jedanNalog.appendChild(modelZaduzenja);
			
			Element pozivNaBrojZaduzenja = doc.createElement("poziv_na_broj_zaduzenja");
			pozivNaBrojZaduzenja.setTextContent(analitikaIzvoda.getPoziv_na_broj_zaduzenja());
			jedanNalog.appendChild(pozivNaBrojZaduzenja);
			
			Element racunPoverioca = doc.createElement("racun_poverioca");
			racunPoverioca.setTextContent(analitikaIzvoda.getRacun_poverioca());
			jedanNalog.appendChild(racunPoverioca);
			
			Element modelOdobrenja = doc.createElement("model_odobrenja");
			modelOdobrenja.setTextContent(String.valueOf(analitikaIzvoda.getModel_odobrenja()));
			jedanNalog.appendChild(modelOdobrenja);
			
			Element pozivNaBrojOdobrenja = doc.createElement("poziv_na_broj_odobrenja");
			pozivNaBrojOdobrenja.setTextContent(analitikaIzvoda.getPoziv_na_broj_odobrenja());
			jedanNalog.appendChild(pozivNaBrojOdobrenja);
			
			Element hitno = doc.createElement("hitno");
			hitno.setTextContent(String.valueOf(analitikaIzvoda.isHitno()));
			jedanNalog.appendChild(hitno);
			
			Element iznos = doc.createElement("iznos");
			iznos.setTextContent(analitikaIzvoda.getIznos().toString());
			jedanNalog.appendChild(iznos);
			
			Element nazivValute = doc.createElement("naziv_valute");
			nazivValute.setTextContent(analitikaIzvoda.getValuta().getNaziv());
			jedanNalog.appendChild(nazivValute);
			
			naloziList.appendChild(jedanNalog);
		}
			
		rootElement.appendChild(naloziList);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource src = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("./exported/nalog_za_medjubankarski_transfer.xml"));
		
		t.transform(src, result);
	}
	
	private static Date findLastDate(List<AnalitikaIzvoda> nalozi) {
		List<Date> dates = new ArrayList<Date>();
		for (AnalitikaIzvoda ai : nalozi) {
			dates.add(ai.getDatum_prijema());
		}
		final Date maxDate = dates.stream().max(Date::compareTo).get();
		return maxDate;
	}
}
