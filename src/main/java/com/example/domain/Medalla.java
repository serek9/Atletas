package com.example.domain;

import javax.persistence.*;

@Entity
public class Medalla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private enum Enumeracion{Oro, Plata, Bronce}
    private String especialidad;
    private String competicion;
    @ManyToOne
    private Atleta atleta;

    public Medalla(String especialidad, String competicion) {
        this.especialidad = especialidad;
        this.competicion = competicion;
    }

    public Medalla(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }
    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }
}