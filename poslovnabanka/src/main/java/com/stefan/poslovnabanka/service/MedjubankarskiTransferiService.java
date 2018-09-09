package com.stefan.poslovnabanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.poslovnabanka.model.MedjubankarskiTransfer;
import com.stefan.poslovnabanka.repository.MedjubankarskiTransferRepository;

@Service
public class MedjubankarskiTransferiService {
	
	@Autowired
	MedjubankarskiTransferRepository medjubankarskiTransferRepository;
	
	public void sacuvaj(MedjubankarskiTransfer medjubankarskiTransfer)
	{
		medjubankarskiTransferRepository.save(medjubankarskiTransfer);
	}
	
	public List<MedjubankarskiTransfer> pronadjiSve()
	{
		return medjubankarskiTransferRepository.findAll();
	}
	
	public MedjubankarskiTransfer pronadjiPoId(int id)
	{
		return medjubankarskiTransferRepository.findOneById(id);
	}
	
	public MedjubankarskiTransfer pronadjiPosljednjiUpisan()
	{
		return medjubankarskiTransferRepository.findAll().get(medjubankarskiTransferRepository.findAll().size()-1);
	}

}
