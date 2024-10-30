package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgenteResponse {
    @JsonProperty("data") // Para el campo data del JSON que contiene todo
    private List<Agente> agentes;

    private int status;

    // Getters
    public List<Agente> getAgentes() {
        return agentes; // Este método debe existir
    }

    public int getStatus() {
        return status;
    }
}