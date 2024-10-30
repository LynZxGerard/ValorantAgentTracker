package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosAgente {
    @JsonAlias("displayName")
    private String nombre;
    @JsonAlias("description")
    private String descripcion;
    private Rol rol;
    private List<Habilidad> habilidades;

    @Override
    public String toString() {
        return "DatosAgente{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rol=" + (rol != null ? rol.toString() : "Sin rol") +
                ", habilidades=" + (habilidades != null ? habilidades.toString() : "Sin habilidades") +
                '}';
    }
}