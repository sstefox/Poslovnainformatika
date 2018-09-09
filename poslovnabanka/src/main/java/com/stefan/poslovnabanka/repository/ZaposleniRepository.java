package com.stefan.poslovnabanka.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stefan.poslovnabanka.model.Zaposleni;

public interface ZaposleniRepository extends CrudRepository<Zaposleni, Integer>{

	@Override
	public List<Zaposleni> findAll();
}
