package com.aluracursos.valorant_api.service;

import com.fasterxml.jackson.databind.ObjectMapper; // Asegúrate de tener la librería Jackson en tu proyecto
import java.io.IOException;

public class ConvierteDatos implements IConvierteDatos {
    private final ObjectMapper objectMapper;

    public ConvierteDatos() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase); // Convierte el JSON a la clase especificada
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones
            return null;
        }
    }
}