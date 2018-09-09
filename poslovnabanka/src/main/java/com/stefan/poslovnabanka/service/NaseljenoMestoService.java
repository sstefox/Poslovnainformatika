package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.NaseljenoMesto;
import com.stefan.poslovnabanka.repository.NaseljenoMestoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaseljenoMestoService {

    @Autowired
    NaseljenoMestoRepository naseljenoMestoRepository;
    
    public void sacuvaj(NaseljenoMesto naseljenoMesto)
    {
    	naseljenoMestoRepository.save(naseljenoMesto);
    }
    
    public List<NaseljenoMesto> dobaviSve()
    {
    	return naseljenoMestoRepository.findAll();
    }
}
