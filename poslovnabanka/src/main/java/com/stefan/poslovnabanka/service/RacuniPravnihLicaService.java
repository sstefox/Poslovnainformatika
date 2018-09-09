package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.RacuniPravnihLica;
import com.stefan.poslovnabanka.repository.RacuniPravnihLicaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RacuniPravnihLicaService {

    @Autowired
    RacuniPravnihLicaRepository racuniPravnihLicaRepository;

    public RacuniPravnihLica pronadjiPoBrojuRacuna(String broj_racuna)
    {
    	return racuniPravnihLicaRepository.findOneByBrojRacuna(broj_racuna);
    }
    
	public void sacuvaj(RacuniPravnihLica racuniPravnihLica) {
		racuniPravnihLicaRepository.save(racuniPravnihLica);
	}
	
	public List<RacuniPravnihLica> dobaviSveVazece(){
		return racuniPravnihLicaRepository.dobaviSveVazece();
	}
	
	public RacuniPravnihLica dobaviJedanRacun(String brojRacuna)
	{
		return racuniPravnihLicaRepository.findOneByBrojRacuna(brojRacuna);
	}
	
	public void ukidanjeRacuna(RacuniPravnihLica racuniPravnihLica)
	{
		racuniPravnihLica.setVazeci(false);
		racuniPravnihLicaRepository.save(racuniPravnihLica);
	}
}
