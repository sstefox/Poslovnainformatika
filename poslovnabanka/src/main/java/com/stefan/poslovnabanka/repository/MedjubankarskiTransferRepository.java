package com.stefan.poslovnabanka.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stefan.poslovnabanka.model.MedjubankarskiTransfer;

public interface MedjubankarskiTransferRepository extends CrudRepository<MedjubankarskiTransfer, Integer> {

	@Override
	public List<MedjubankarskiTransfer> findAll();
	
	public MedjubankarskiTransfer findOneById(int id);
}
