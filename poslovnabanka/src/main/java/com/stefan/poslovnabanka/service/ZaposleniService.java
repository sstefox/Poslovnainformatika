package com.stefan.poslovnabanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.poslovnabanka.model.Zaposleni;
import com.stefan.poslovnabanka.repository.ZaposleniRepository;

@Service
public class ZaposleniService {

	@Autowired
	ZaposleniRepository zaposleniRepository;
	
	public List<Zaposleni> dobaviSve()
	{
		return zaposleniRepository.findAll();
	}

	public void save(Zaposleni zaposleni) {
		zaposleniRepository.save(zaposleni);
		
	}
}
