package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.Valuta;
import com.stefan.poslovnabanka.repository.ValutaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValutaService {

    @Autowired
    ValutaRepository valutaRepository;
    
    public void sacuvaj(Valuta valuta)
    {
    	valutaRepository.save(valuta);
    }
    
    public List<Valuta> dobaviSve()
    {
    	return valutaRepository.findAll();
    }
    
    public Valuta dobaviValutuPoNazivu(String naziv)
    {
    	return valutaRepository.findOneByNaziv(naziv);
    }
}
