package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRol(
        @JsonAlias("displayName") String nombreRol,
        @JsonAlias("description") String descripcionRol
) {}
