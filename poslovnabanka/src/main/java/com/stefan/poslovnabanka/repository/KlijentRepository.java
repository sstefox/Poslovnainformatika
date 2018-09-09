package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.Klijent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KlijentRepository  extends CrudRepository<Klijent,Integer> {
	
	@Override
    List<Klijent> findAll();
}
