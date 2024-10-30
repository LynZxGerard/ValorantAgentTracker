package com.aluracursos.valorant_api;

import com.aluracursos.valorant_api.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValorantApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ValorantApiApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menuPrincipal();
	}
}
