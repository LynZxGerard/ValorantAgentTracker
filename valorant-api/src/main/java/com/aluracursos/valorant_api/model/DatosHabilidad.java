package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosHabilidad(
        @JsonAlias("displayName") String nombreHabilidad,
        @JsonAlias("description") String descripcionHabilidad
) {}
