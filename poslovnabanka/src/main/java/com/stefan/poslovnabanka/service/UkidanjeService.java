package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.RacuniPravnihLica;
import com.stefan.poslovnabanka.model.Ukidanje;
import com.stefan.poslovnabanka.repository.RacuniPravnihLicaRepository;
import com.stefan.poslovnabanka.repository.UkidanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UkidanjeService {

    @Autowired
    UkidanjeRepository ukidanjeRepository;
    
    @Autowired
    RacuniPravnihLicaRepository racuniPravnihLicaRepository;
    
    public void izvrsiUkidanje(Ukidanje ukidanje)
    {
    	ukidanjeRepository.save(ukidanje);
    	
    	RacuniPravnihLica racuniPravnihLica = racuniPravnihLicaRepository.findOneById(ukidanje.getUkidanjeRacuna().getId());
    	racuniPravnihLica.setVazeci(false);
    	
    	racuniPravnihLicaRepository.save(racuniPravnihLica);
    	
    }
}
