package com.example.service;

import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private MedallaRepository medallaRepository;

    public void testAtletas(){

        Atleta atleta1 = new Atleta("Alberto", "Comuñas", "Suiza", LocalDate.of(1990,12,12));
        atletaRepository.save(atleta1);
        Atleta atleta2 = new Atleta("Sergio", "Díaz", "Mundo", LocalDate.of(1996,8,8));
        atletaRepository.save(atleta2);
        Atleta atleta3 = new Atleta("Nando", "Aranda", "U.S.", LocalDate.of(1991,12,12));
        atletaRepository.save(atleta3);
        Atleta atleta4 = new Atleta("Larry", "Andre", "Peru", LocalDate.of(1992,12,12));
        atletaRepository.save(atleta4);
        Atleta atleta5 = new Atleta("Victor", "Amador", "Francia", LocalDate.of(1993,12,12));
        atletaRepository.save(atleta5);

    }
}
