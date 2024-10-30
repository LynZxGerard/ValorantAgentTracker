# Valorant Agent Tracker
El **Valorant Agent Tracker** es una aplicación que interactúa con una API pública de [Valorant](https://valorant-api.com),  para proporcionar una experiencia mejorada en el acceso a informacion de agentes del juego. Este proyecto permite la carga y filtración de datos de agentes utilizando Java y el framework Spring 3.3.5. No se requiere una clave de API, ya que se trata de una API pública.

Para mas informacion del funcionamiento de la API de valorant se puede visitar su [Repositorio](https://github.com/Valorant-API/java-library?tab=readme-ov-file)

## Tecnologías Utilizadas

-   **Java**: Versión 21
-   **Spring Framework**: Versión 3.3.5
-   **Maven**: Gestión de dependencias y construcción del proyecto
-   **Jackson Databind**: Para el parsing de datos JSON

## Características

-   **Carga de Agentes**: Obtiene información actualizada sobre los agentes directamente desde la API.
-   **Filtrado Avanzado**:
    -   **Buscar por Nombre**: Localiza agentes específicos mediante su nombre.
    -   **Filtrar por Rol**: Permite encontrar agentes en función de su rol en el juego (Duelist, Sentinel, Controller, Initiator).
    -   **Buscar por País**: Filtra agentes según su país o nacionalidad, ofreciendo funcionalidades que no están disponibles en la API original.

<div align="center">
    <a href="https://imgbb.com/">
        <img src="https://i.ibb.co/f8YF1WY/image.png" alt="Menu Principal" border="0">
    </a>
</div>

## Conceptos Implementados

Este proyecto aplica varios conceptos de programación moderna en Java, tales como:

-   **Funciones Lambda**: Para simplificar la manipulación de colecciones.
-   **Streams**: Para realizar filtraciones y transformaciones de datos de manera eficiente.
-   **Interfaces**: Para definir comportamientos específicos que mejoran la modularidad del código.

## Instalación

1.  Clona el repositorio:
   `git clone https://github.com/LynZxGerard/ValorantAgentTracker` 
    
2.  Navega al directorio del proyecto:
`cd valorant-api` 
    
3.  Compila el proyecto usando Maven:
`mvn clean install` 
    
4.  Ejecuta la aplicación:
 `mvn spring-boot:run` 
    

