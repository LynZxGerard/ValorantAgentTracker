package com.aluracursos.valorant_api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.aluracursos.valorant_api.model.Agente;
import com.aluracursos.valorant_api.model.AgenteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AgenteManager {
    private HashMap<String, Agente> agenteDictionary;
    private List<Agente> agentes;
    private final ConsumoAPI consumoAPI;

    public AgenteManager() {
        agentes = new ArrayList<>();
        this.agenteDictionary = new HashMap<>();
        this.consumoAPI = new ConsumoAPI();
        cargarAgentesDesdeApi();
    }

    public void cargarAgentesDesdeApi() {
        String json = hacerSolicitudApi(); // Realiza la solicitud a la API
        List<Agente> agentesDesdeApi = deserializarAgentes(json); // Deserializa los agentes desde el JSON

        // Cargar agentes en la lista y en el diccionario
        if (agentesDesdeApi != null) {
            agentes.clear(); // Limpiar la lista antes de agregar nuevos agentes
            agentesDesdeApi.forEach(agente -> {
                agentes.add(agente); // Agregar a la lista de agentes
                agenteDictionary.put(agente.getUuid(), agente); // Cargar en el diccionario
            });
        }
    }

    private List<Agente> deserializarAgentes(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Agente> agentes = null;

        try {
            // Deserializa el JSON en un objeto de tipo AgenteResponse
            AgenteResponse response = objectMapper.readValue(json, AgenteResponse.class);
            agentes = response.getAgentes();
        } catch (IOException e) {
            e.printStackTrace(); // Manejar excepciones
        }
        return agentes; // Retorna la lista de agentes o null en caso de error
    }

    public Agente obtenerAgentePorNombre(String nombre) {
        return agenteDictionary.values().stream()
                .filter(agente -> agente.getDisplayName().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null); // Retorna el agente o null si no se encuentra
    }

    private String hacerSolicitudApi() {
        return consumoAPI.obtenerDatos("https://valorant-api.com/v1/agents"); // URL de la API
    }

    public List<Agente> obtenerAgentesPorRol(String rol) {
        return agenteDictionary.values().stream()
                .filter(agente -> agente.getRole() != null && agente.getRole().toString().equalsIgnoreCase(rol)) // Filtra por rol
                .collect(Collectors.toList()); // Recoge el resultado en una lista
    }

    public void mostrarAgentesPorRol(String rol) {
        List<Agente> agentesPorRol = obtenerAgentesPorRol(rol); // Obtiene la lista de agentes por rol

        if (!agentesPorRol.isEmpty()) {
            System.out.println("\n=====================================================================[   Agents found with role: " + rol.toUpperCase() + "   ]=====================================================================\n");
            agentesPorRol.stream()
                    .map(Agente::mostrarInformacionAgente) // Convierte cada Agente a su representación de cadena
                    .forEach(System.out::println); // Imprime cada información de agente
        } else {
            System.out.println("No agents found with the role: " + rol);
        }
    }

    public List<Agente> obtenerAgentesPorPais(String pais) {
        return agentes.stream()
                .filter(agente -> agente.getDescription().toLowerCase().contains(pais.toLowerCase())) // Filtra agentes por país
                .peek(agente -> System.out.println("\nAgent from " + pais.toLowerCase() + " found! \n")) // Imprime el mensaje para todos los que coincidan
                .collect(Collectors.toList()); // Recoge el resultado en una lista
    }
}