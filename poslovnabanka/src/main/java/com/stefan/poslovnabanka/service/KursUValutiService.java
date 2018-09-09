package com.stefan.poslovnabanka.service;

import com.stefan.poslovnabanka.repository.KursUValutiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KursUValutiService {

    @Autowired
    KursUValutiRepository kursUValutiRepository;
}
