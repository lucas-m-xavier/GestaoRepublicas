package com.dev.republica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dev.republica.model.Representante;
import com.dev.republica.model.Republica;
import com.dev.republica.repository.RepresentanteRepository;
import com.dev.republica.service.RepublicaService;

@SpringBootApplication
public class RepublicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepublicaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RepublicaService republicaService, RepresentanteRepository representanteRepository) {
		return args -> {
			Representante r1 = representanteRepository.save(new Representante(1L, "Joaquim"));
			Representante r2 = representanteRepository.save(new Representante(2L, "Mateus"));
			Representante r3 = representanteRepository.save(new Representante(3L, "Natália"));
			Representante r4 = representanteRepository.save(new Representante(4L, "Amaral"));
			Representante r5 = representanteRepository.save(new Representante(5L, "Bruna"));
			Representante r6 = representanteRepository.save(new Representante(6L, "Bruno"));

			republicaService.save(new Republica(1L, "Disneylandia", "Rua José Alfredo, nº 20", (byte) 3, "Casa",
					"Masculina", "Joaquim, Fernando", (byte) 3, "Microondas, Fogão, Geladeira", "XBOX, PS4", (byte) 1,
					"Rock todos os dias!", r1, "-", "Física"));

			republicaService.save(new Republica(2L, "Ilha da macacada", "Rua 4, nº 30", (byte) 3, "Casa", "Masculina",
					"Mateus, João", (byte) 3, "Cafeteira, Omeleteira, Fogão, Geladeira", "Sinuca", (byte) 1,
					"Rock todo final de semana", r2, "-", "Agronomia"));

			republicaService.save(new Republica(3L, "Filhos do Stewart", "Rua Miguel de Assis, nº 5", (byte) 4,
					"Apartamento", "Feminina", "Natália, Roberta, Marcela", (byte) 4,
					"Microondas, Fogão, Geladeira, Máquina de lavar roupa", "Secador de cabelo, chapinha", (byte) 1,
					"-", r3, "-", "Matemática"));

			republicaService.save(new Republica(4L, "Cachorrão", "Rua Jucelino, nº 99", (byte) 5, "Apartamento",
					"Masculina", "Amaral, Breno, Pedro, Julio", (byte) 5, "Microondas, Fogão, Geladeira",
					"XBOX, Totó, Som", (byte) 1, "-", r4, "-", "Nenhum"));

			republicaService.save(new Republica(5L, "Saara", "Rua Ulices Junior, nº 50", (byte) 3, "Casa", "Feminina",
					"Bruna, Fernanda", (byte) 3, "Microondas, Fogão, Geladeira", "-", (byte) 1, "-", r5, "-",
					"Biologia"));

		};
	}

}
