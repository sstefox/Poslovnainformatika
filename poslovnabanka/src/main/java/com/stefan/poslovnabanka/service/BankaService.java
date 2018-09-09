package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.Banka;
import com.stefan.poslovnabanka.repository.BankaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankaService {

    @Autowired
    BankaRepository bankaRepository;
    
    
    public void sacuvajBanku(Banka banka) {
    	bankaRepository.save(banka);
    }
    
    public List<Banka> dobaviSve()
    {
    	return bankaRepository.findAll();
    }
    
    public Banka pronadjiJednuPoRacunu(String racun)
    {
    	return bankaRepository.pronadjiBankuPoRacunu(Integer.valueOf(racun.substring(2)));
    }
    
}
