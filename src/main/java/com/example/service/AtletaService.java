package com.example.service;

import com.example.domain.Atleta;
import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
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

        Medalla medalla1 = new Medalla(TipoMedalla.valueOf("PLATA"),"BMX", "X Games", atleta2);
        medallaRepository.save(medalla1);
        Medalla medalla2 = new Medalla(TipoMedalla.valueOf("ORO"),"Skate", "X Games", atleta1);
        medallaRepository.save(medalla2);
        Medalla medalla3 = new Medalla(TipoMedalla.valueOf("PLATA"),"Surf", "X Games", atleta2);
        medallaRepository.save(medalla3);
        Medalla medalla4 = new Medalla(TipoMedalla.valueOf("BRONCE"),"Snow", "X Games", atleta1);
        medallaRepository.save(medalla4);
        Medalla medalla5 = new Medalla(TipoMedalla.valueOf("ORO"),"MTB", "X Games", atleta2);
        medallaRepository.save(medalla5);
        Medalla medalla6 = new Medalla(TipoMedalla.valueOf("PLATA"),"ATV", "X Games", atleta3);
        medallaRepository.save(medalla6);
        Medalla medalla7 = new Medalla(TipoMedalla.valueOf("BRONCE"),"MX", "X Games", atleta4);
        medallaRepository.save(medalla7);

    }
}
