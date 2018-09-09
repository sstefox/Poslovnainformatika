package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;
import com.stefan.poslovnabanka.repository.DnevnoStanjeRacunaRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnevnoStanjeRacunaService {

    @Autowired
    DnevnoStanjeRacunaRepository dnevnoStanjeRacunaRepository;
    
    public void upisStanja(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
    	dnevnoStanjeRacunaRepository.save(dnevnoStanjeRacuna);
    }
    
    public DnevnoStanjeRacuna dobaviPoslednjeStanjeZaKlijenta(int id)
    {
    	List<DnevnoStanjeRacuna> dnevno = new ArrayList<>();
    	for(DnevnoStanjeRacuna d:dnevnoStanjeRacunaRepository.findAll()) {
    		if(d.getRacuniPravnihLica().getId() == id) {
    			dnevno.add(d);
    		}
    	}
    	
    	return dnevno.get(dnevno.size()-1);
    }
    
    public List<DnevnoStanjeRacuna> dobaviSve()
    {
    	return dnevnoStanjeRacunaRepository.findAll();
    }
    
    public List<DnevnoStanjeRacuna> dobaviSveZaJednogKlijenta(int id)
    {
    	return dnevnoStanjeRacunaRepository.pronajdiSvePoIdKlijenta(id);
    }
}
