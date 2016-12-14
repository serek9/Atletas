package com.example.service;

import com.example.domain.Atleta;
import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
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

        //EN ATLETASERVICE

    }
}
