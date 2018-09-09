package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.Valuta;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ValutaRepository extends CrudRepository<Valuta,Integer>{
	
	@Override
    List<Valuta> findAll();

	public Valuta findOneByNaziv(String naziv);
}
