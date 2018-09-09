package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.Drzava;
import com.stefan.poslovnabanka.model.NaseljenoMesto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NaseljenoMestoRepository  extends CrudRepository<NaseljenoMesto,Integer> {
	
	@Override
    List<NaseljenoMesto> findAll();
}
