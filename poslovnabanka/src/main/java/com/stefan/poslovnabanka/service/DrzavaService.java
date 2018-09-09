package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.Drzava;
import com.stefan.poslovnabanka.repository.DrzavaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrzavaService {

    @Autowired
    DrzavaRepository drzavaRepository;
    
    public void sacuvajDrzavu(Drzava drzava) {
    	drzavaRepository.save(drzava);
    }
    
    public List<Drzava> dobaviSve()
    {
    	return drzavaRepository.findAll();
    }
    
    public Drzava pronadjiJednu(Integer id)
    {
    	return drzavaRepository.findOneById(id);
    }
}
