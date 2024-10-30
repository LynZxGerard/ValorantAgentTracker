package com.aluracursos.valorant_api.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
