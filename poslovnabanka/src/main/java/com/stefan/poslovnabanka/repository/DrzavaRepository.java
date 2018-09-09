package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.Drzava;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DrzavaRepository  extends CrudRepository<Drzava,Integer> {
	
	@Override
    List<Drzava> findAll();
	
	public Drzava findOneById(int id);
}
