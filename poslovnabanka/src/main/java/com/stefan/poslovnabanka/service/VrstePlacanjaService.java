package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.repository.VrstePlacanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VrstePlacanjaService {

    @Autowired
    VrstePlacanjaRepository vrstePlacanjaRepository;
}
