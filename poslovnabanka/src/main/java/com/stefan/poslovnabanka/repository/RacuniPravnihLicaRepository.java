package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.RacuniPravnihLica;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RacuniPravnihLicaRepository  extends CrudRepository<RacuniPravnihLica,Integer> {
	public RacuniPravnihLica findOneById(int id);

	@Query("from RacuniPravnihLica a where a.vazeci=true")
	public List<RacuniPravnihLica> dobaviSveVazece();
	
	@Query("from RacuniPravnihLica a where a.broj_racuna=:brojRacuna")
	public RacuniPravnihLica findOneByBrojRacuna(@Param("brojRacuna") String broj_racuna);
}
