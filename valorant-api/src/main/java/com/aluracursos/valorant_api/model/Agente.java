package com.aluracursos.valorant_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agente {
    private String uuid;
    private String displayName;
    private String description;
    private Rol role;
    private List<Habilidad> abilities;

    // Getters
    public String getUuid() {
        return uuid;
    }

    public List<Habilidad> getAbilities() {
        return abilities;
    }

    public Rol getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String mostrarInformacionAgente() {
        if (displayName == null || displayName.isEmpty()) {
            return "Agent not found.";  // Retorna un mensaje si el agente no tiene un nombre definido
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Agent name: ").append(displayName).append("\n")
                .append("Description: ").append(description != null ? description : "No description").append("\n")
                .append("Role: ").append(role != null ? role.toString() : "No role").append("\n")
                .append("Abilities:\n");

        if (abilities != null && !abilities.isEmpty()) {
            for (Habilidad habilidad : abilities) {
                sb.append("  - ").append(habilidad.toString()).append("\n"); // Formato con guión y salto de línea
            }
        } else {
            sb.append("  - No abilities\n");  // Mensaje si no hay habilidades
        }
        return sb.toString();
    }
}
