package com.aluracursos.valorant_api.principal;

import com.aluracursos.valorant_api.model.Agente;
import com.aluracursos.valorant_api.service.AgenteManager;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public void menuPrincipal(){
        AgenteManager agenteManager = new AgenteManager();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true; // Variable para controlar el ciclo del menú

        while (continuar) {
            // Mostrar menú

            System.out.println("······································································");

            System.out.println("    __     __    _                       _        _    ____ ___ ");
            System.out.println("    \\ \\   / /_ _| | ___  _ __ __ _ _ __ | |_     / \\  |  _ \\_ _|");
            System.out.println("     \\ \\ / / _` | |/ _ \\| '__/ _` | '_ \\| __|   / _ \\ | |_) | | ");
            System.out.println("      \\ V / (_| | | (_) | | | (_| | | | | |_   / ___ \\|  __/| | ");
            System.out.println("       \\_/ \\__,_|_|\\___/|_|  \\__,_|_| |_|\\__| /_/   \\_\\_|  |___|");

            System.out.println("\n······································································");

            System.out.println("1. Search agent by name");
            System.out.println("2. Filter agents by role");
            System.out.println("3. Filter agents by country or nationality");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4) -> ");

            try {
                int opcion = scanner.nextInt(); // Captura la opción del usuario
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1: // Buscar por nombre
                        System.out.print("Enter the agent's name: ");
                        String nombreAgente = scanner.nextLine(); // Captura la entrada del usuario
                        Agente agente = agenteManager.obtenerAgentePorNombre(nombreAgente);
                        System.out.println(agente != null ? agente.mostrarInformacionAgente() : "Agent not found.");
                        break;

                    case 2: // Filter by role
                        System.out.print("Enter the agent's role (e.g., Duelist, Sentinel, Controller, Initiator): ");
                        String rolAgente = scanner.nextLine();

                        // Switch for handling sub-options within roles
                        switch (rolAgente.toLowerCase()) {
                            case "duelist":
                            case "sentinel":
                            case "controller":
                            case "initiator":
                                agenteManager.mostrarAgentesPorRol(rolAgente);
                                break;
                            default:
                                System.out.println("Invalid role. Please choose from Duelist, Sentinel, Controller, or Initiator.");
                        }
                        break;

                    case 3: // Filtrar por país
                        System.out.print("Enter the country or nationality of the agent: ");
                        String pais = scanner.nextLine();
                        List<Agente> agentesPorPais = agenteManager.obtenerAgentesPorPais(pais);
                        if (!agentesPorPais.isEmpty()) {
                            for (Agente agente3 : agentesPorPais) {
                                System.out.println(agente3.mostrarInformacionAgente());
                            }
                        } else {
                            System.out.println("No agents found in the country: " + pais);
                        }
                        break;

                    case 4: // Salir
                        continuar = false; // Cambia la variable para salir del ciclo
                        System.out.println("Exiting the program. See you later!");
                        break;

                    default: // Opción no válida
                        System.out.println("Invalid option. Please select an option between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4."); // Mensaje para entradas inválidas
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        }

        // Cerrar el Scanner
        scanner.close();
    }
}
