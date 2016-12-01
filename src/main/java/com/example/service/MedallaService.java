package com.example.service;

import com.example.domain.Atleta;
import com.example.domain.Medalla;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedallaService {
    @Autowired
    private MedallaRepository medallaRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    public void testMedallas(){

        Medalla medalla1 = new Medalla("BMX", "X Games");
        medallaRepository.save(medalla1);
        Medalla medalla2 = new Medalla("Skate", "X Games");
        medallaRepository.save(medalla2);
        Medalla medalla3 = new Medalla("Surf", "X Games");
        medallaRepository.save(medalla3);
        Medalla medalla4 = new Medalla("Snow", "X Games");
        medallaRepository.save(medalla4);
        Medalla medalla5 = new Medalla("MTB", "X Games");
        medallaRepository.save(medalla5);
        Medalla medalla6 = new Medalla("ATV", "X Games");
        medallaRepository.save(medalla6);
        Medalla medalla7 = new Medalla("MX", "X Games");
        medallaRepository.save(medalla7);

    }
}
