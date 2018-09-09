package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.DnevnoStanjeRacuna;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DnevnoStanjeRacunaRepository  extends CrudRepository<DnevnoStanjeRacuna,Integer> {
	
	@Override
    List<DnevnoStanjeRacuna> findAll();
	
	@Query("from DnevnoStanjeRacuna where racuniPravnihLica=:id")
	public List<DnevnoStanjeRacuna> pronajdiSvePoIdKlijenta(@Param("id") int id);
	
}
