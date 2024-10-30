package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAgenteRaw(
        @JsonAlias("displayName") String nombre,
        @JsonAlias("description") String descripcion,
        @JsonAlias("role") DatosRol rol,
        @JsonAlias("abilities") List<DatosHabilidad> habilidades
) {}
