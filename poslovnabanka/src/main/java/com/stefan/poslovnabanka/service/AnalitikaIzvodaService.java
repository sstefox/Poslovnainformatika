package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.AnalitikaIzvoda;
import com.stefan.poslovnabanka.repository.AnalitikaIzvodaRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalitikaIzvodaService {

    @Autowired
    AnalitikaIzvodaRepository analitikaIzvodaRepository;
    
    public void uplata(AnalitikaIzvoda analitikaIzvoda) {
    	analitikaIzvodaRepository.save(analitikaIzvoda);
    }
    
    public List<AnalitikaIzvoda> pronadjiSveNeizvrsene()
    {
    	return analitikaIzvodaRepository.pronadjiSveNeizvrsene();
    }
    
    public List<AnalitikaIzvoda> pronadjiSve()
    {
    	return analitikaIzvodaRepository.findAll();
    }
    
    public List<AnalitikaIzvoda> pronadjiSveSaIstimMedjuBankarskimTransferom(int id)
    {
    	List<AnalitikaIzvoda> analitikaIzvodaList = new ArrayList<>();
    	for(AnalitikaIzvoda a:analitikaIzvodaRepository.findAll())
    	{
    		if(a.getMedjubankarskiTransfer().getId() == id)
    		{
    			analitikaIzvodaList.add(a);
    		}
    	}
    	
    	return analitikaIzvodaList;
    }
    
}
