package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.model.KursnaLista;
import com.stefan.poslovnabanka.repository.KursnaListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KursnaListaService {

    @Autowired
    KursnaListaRepository kursnaListaRepository;
    
    public void sacuvaj(KursnaLista kursnaLista)
    {
    	kursnaListaRepository.save(kursnaLista);
    }
}
