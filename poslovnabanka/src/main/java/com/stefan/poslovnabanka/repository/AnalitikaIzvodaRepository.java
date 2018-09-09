package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.AnalitikaIzvoda;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnalitikaIzvodaRepository  extends CrudRepository<AnalitikaIzvoda,Integer> {
	
	@Query(value="select * from analitika_izvoda where status=false",nativeQuery=true)
	public List<AnalitikaIzvoda> pronadjiSveNeizvrsene();
	
	@Override
	public List<AnalitikaIzvoda> findAll();
}
