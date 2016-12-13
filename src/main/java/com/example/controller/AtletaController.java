package com.example.controller;


import com.example.domain.Atleta;
import com.example.domain.Medalla;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;
    @Autowired
    private MedallaRepository medallaRepository;

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
    @GetMapping("/byNacimientoAntes/{nacimiento}")
    public List<Atleta> findByNacimientoAntes(@PathVariable String nacimiento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(nacimiento, formatter);
        return atletaRepository
                .findAll()
                .parallelStream()
                .filter(atleta -> atleta.getFechan().isBefore(fecha))
                .collect(Collectors.toList());
    }

    //ATLETAS AGRUPADOS POR NACIONALIDAD EN UN MAP(LIST ATLETA)
    @GetMapping("/byNacionalidadMap")
    public Map<String, List<Atleta>> findByNacionalidadMap(){
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(Atleta::getNacionalidad));
    }
    //ATLETAS AGRUPADOS POR MEDALLLA EN UN MAP(LIST ATLETA)
    @GetMapping("/byTipoMedalla")
    public Map<enum Enumeracion{Oro, Plata, Bronce}, List<Medalla>> findByTipoMedalla(){
        return medallaRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(Medalla::))
    }
}
