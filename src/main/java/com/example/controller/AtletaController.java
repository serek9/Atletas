package com.example.controller;


import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createAtleta(@RequestBody Atleta atleta){ return atletaRepository.save(atleta);}

    @PutMapping
    public Atleta updateAtleta(@RequestBody Atleta atleta){ return atletaRepository.save(atleta);}

    @GetMapping
    public List<Atleta> findAll(){ return atletaRepository.findAll();}

    //ATLETAS DE UNA NACIONALIDAD DETERMINADA
    @GetMapping("/byNacionalidad/{nacionalidad}")
    public List<Atleta> findByNacionalidad(@PathVariable String nacionalidad){
        return atletaRepository
                .findAll()
                .parallelStream()
                .filter(atleta -> atleta.getNacionalidad().toLowerCase().equals(nacionalidad.toLowerCase()))
                .collect(Collectors.toList());
    }

    //ATLETAS K HAYAN NACIDO ANTERIOR A FECHA DETERMINADA

    //ATLETAS AGRUPADOS POR NACIONALIDAD EN UN MAP(LIST ATLETA)

    //ATLETAS AGRUPADOS POR MEDALLLA EN UN MAP(LIST ATLETA)
}
