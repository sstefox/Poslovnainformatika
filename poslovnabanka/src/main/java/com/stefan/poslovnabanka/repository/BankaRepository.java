package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.Banka;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BankaRepository  extends CrudRepository<Banka,Integer> {
	
	@Override
    List<Banka> findAll();

	@Query("from Banka where id=:id")
	public Banka pronadjiBankuPoRacunu(@Param("id") Integer id);
	
	public Banka findOneById(int id);
}
