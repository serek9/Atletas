package com.example.controller;

import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medallas")
public class MedallaController {

    @Autowired
    private MedallaRepository medallaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medalla createMedalla(@RequestBody Medalla medalla){ return medallaRepository.save(medalla);}

    @PutMapping
    public Medalla updateMedalla(@RequestBody Medalla medalla){ return medallaRepository.save(medalla);}

    @GetMapping
    public List<Medalla> findAllMedallas(){ return medallaRepository.findAll();}

    //ATLETAS AGRUPADOS POR MEDALLLA EN UN MAP(LIST ATLETA)
    @GetMapping("/byTipoMedalla")
    public Map<TipoMedalla, List<Medalla>> findByTipoMedalla(){
        return medallaRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(Medalla::getTipoMedalla));
    }
}
