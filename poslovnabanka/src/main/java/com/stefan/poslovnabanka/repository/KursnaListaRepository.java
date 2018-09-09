package com.stefan.poslovnabanka.repository;

import com.stefan.poslovnabanka.model.KursnaLista;
import org.springframework.data.repository.CrudRepository;

public interface KursnaListaRepository  extends CrudRepository<KursnaLista,Integer> {
}
