package com.stefan.poslovnabanka.jasper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stefan.poslovnabanka.model.AnalitikaIzvoda;
import com.stefan.poslovnabanka.model.Klijent;
import com.stefan.poslovnabanka.repository.AnalitikaIzvodaRepository;
import com.stefan.poslovnabanka.repository.KlijentRepository;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class IzvodKlijentaDataSource extends JRAbstractBeanDataSourceProvider {

	AnalitikaIzvodaRepository analitikaIzvodaRepository;
	Date datum_od,datum_do;
	String racun;
	
	public IzvodKlijentaDataSource(AnalitikaIzvodaRepository analitikaIzvodaRepository,Date datum_od,Date datum_do,String racun){
		super(Klijent.class);
		this.analitikaIzvodaRepository = analitikaIzvodaRepository;
		this.datum_do = datum_do;
		this.datum_od = datum_od;
		this.racun = racun;
	}
	
	@Override
	public JRDataSource create(JasperReport arg0) throws JRException {
		List<AnalitikaIzvoda> analitikaIzvoda = new ArrayList<>();
		for(AnalitikaIzvoda a: analitikaIzvodaRepository.findAll())
		{
			if(a.getRacun_duznika().equals(racun) || a.getRacun_poverioca().equals(racun))
			{
				if(datum_od.before(a.getDatum_prijema()) && datum_do.after(a.getDatum_prijema()) ) {
					analitikaIzvoda.add(a);
				}
			}
		}
		return new JRBeanCollectionDataSource(analitikaIzvoda);
	}

	@Override
	public void dispose(JRDataSource arg0) throws JRException {
		// TODO Auto-generated method stub
		
	}


}
