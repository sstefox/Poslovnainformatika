package com.stefan.poslovnabanka.jasper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stefan.poslovnabanka.model.AnalitikaIzvoda;
import com.stefan.poslovnabanka.model.Banka;
import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;
import com.stefan.poslovnabanka.model.Klijent;
import com.stefan.poslovnabanka.model.RacuniPravnihLica;
import com.stefan.poslovnabanka.model.SpisakRacunaModel;
import com.stefan.poslovnabanka.repository.AnalitikaIzvodaRepository;
import com.stefan.poslovnabanka.repository.BankaRepository;
import com.stefan.poslovnabanka.repository.DnevnoStanjeRacunaRepository;
import com.stefan.poslovnabanka.repository.RacuniPravnihLicaRepository;
import com.stefan.poslovnabanka.service.RacuniPravnihLicaService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SpisakRacunaDataSource extends JRAbstractBeanDataSourceProvider {

	DnevnoStanjeRacunaRepository dnevnoStanjeRacunaRepository;
	BankaRepository bankaRepository;
	RacuniPravnihLicaRepository racuniPravnihLicaRepository;
	int banka;
	
	
	
	public SpisakRacunaDataSource(DnevnoStanjeRacunaRepository dnevnoStanjeRacunaRepository,int banka_id,BankaRepository bankaRepository,RacuniPravnihLicaRepository racuniPravnihLicaRepository){
		super(Banka.class);
		this.dnevnoStanjeRacunaRepository = dnevnoStanjeRacunaRepository;
		this.bankaRepository = bankaRepository;
		this.racuniPravnihLicaRepository = racuniPravnihLicaRepository;
		this.banka = banka_id;
	}
	
	@Override
	public JRDataSource create(JasperReport arg0) throws JRException {
		List<SpisakRacunaModel> spisakRacunaModel = new ArrayList<>();
		for(DnevnoStanjeRacuna d: dnevnoStanjeRacunaRepository.findAll())
		{
			if(d.getRacuniPravnihLica().getPoslovna_banka().getId() == banka) {
				SpisakRacunaModel s = new SpisakRacunaModel();
				s.setNovo_stanje(String.valueOf(d.getNovo_stanje()));
				s.setDatum(String.valueOf(d.getDatum_prometa()));
				s.setBroj_racuna(d.getRacuniPravnihLica().getBroj_racuna());
				s.setIme_banke(bankaRepository.findOneById(banka).getNaziv());
				spisakRacunaModel.add(s);
			}
		}
		return new JRBeanCollectionDataSource(spisakRacunaModel,false);
	}

	@Override
	public void dispose(JRDataSource arg0) throws JRException {
		// TODO Auto-generated method stub
		
	}


}
