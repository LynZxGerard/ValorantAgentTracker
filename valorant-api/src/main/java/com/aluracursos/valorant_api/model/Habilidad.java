package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Habilidad {
    private String slot;
    private String displayName;
    private String description;

    // Getters
    public String getSlot() {
        return slot;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return displayName + ": " + description;
    }

}