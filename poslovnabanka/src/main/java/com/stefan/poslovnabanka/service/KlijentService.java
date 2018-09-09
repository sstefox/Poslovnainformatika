package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.Klijent;
import com.stefan.poslovnabanka.repository.KlijentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlijentService {

    @Autowired
    KlijentRepository klijentRepository;


    public void save(Klijent klijent){
        klijentRepository.save(klijent);
    }
    
    public List<Klijent> dobaviSve()
    {
    	return klijentRepository.findAll();
    }

}
