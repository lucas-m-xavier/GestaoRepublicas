package com.dev.republica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dev.republica.model.Feedback;
import com.dev.republica.model.Historico;
import com.dev.republica.model.Morador;
import com.dev.republica.model.MoradorReceitaDespesa;
import com.dev.republica.model.ReceitaDespesa;
import com.dev.republica.model.Republica;
import com.dev.republica.model.Usuario;
import com.dev.republica.model.UsuarioPrincipal;
import com.dev.republica.repository.FeedbackRepository;
import com.dev.republica.repository.HistoricoRepository;
import com.dev.republica.repository.MoradorReceitaDespesaRepository;
import com.dev.republica.repository.MoradorRepository;
import com.dev.republica.repository.ReceitaDespesaRepository;
import com.dev.republica.repository.RepublicaRepository;
import com.dev.republica.repository.UsuarioRepository;

@SpringBootApplication
public class RepublicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepublicaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RepublicaRepository republicaRepository, MoradorRepository moradorRepository,
			ReceitaDespesaRepository receitaDespesaRepository, FeedbackRepository feedbackRepository,
			MoradorReceitaDespesaRepository moradorReceitaDespesaRepository, HistoricoRepository historicoRepository,
			UsuarioRepository usuarioRepository) {
		return args -> {

			Date d = new Date();

			Morador m1 = moradorRepository.save(new Morador(1L, "Joaquim"));
			Morador m2 = moradorRepository.save(new Morador(2L, "Fernando"));
			Morador m3 = moradorRepository.save(new Morador(3L, "José"));
			Morador m4 = moradorRepository.save(new Morador(4L, "Afonso"));
			Morador m5 = moradorRepository.save(new Morador(5L, "Pedro"));

			Republica re1 = republicaRepository
					.save(new Republica(1L, "Disneylandia", "Rua José Alfredo, nº 20", (byte) 3, "Casa", "Masculina",
							(byte) 3, "Microondas, Fogão, Geladeira", "XBOX, PS4", "Rock todos os dias!", m1, "-"));
			m1.setRepublica(re1);
			moradorRepository.save(m1);
			Republica re2 = republicaRepository
					.save(new Republica(2L, "Carandiru", "Rua Marcio da quitanda, nº 113", (byte) 9, "Casa", "Mista",
							(byte) 8, "Casa com mobilia", "Uma turma do barulho", "-", m3, "carandiru.com.br"));
			m2.setRepublica(re2);
			moradorRepository.save(m2);

			m3.setRepublica(re2);
			re2.addMorador(m3);
			moradorRepository.save(m3);

			m4.setRepublica(re1);
			moradorRepository.save(m4);

			republicaRepository.save(re1);
			republicaRepository.save(re2);

			receitaDespesaRepository.save(new ReceitaDespesa(1L, re1, "Despesa", "Conta de Água", (float) 30.0,
					"Mensal", true, (float) 10.0, d, d, true));
			receitaDespesaRepository.save(new ReceitaDespesa(2L, re2, "Despesa", "Conta de Água", (float) 30.0,
					"Mensal", true, (float) 10.0, d, d, true));

			LocalDate data = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			Feedback f = feedbackRepository.save(new Feedback(1L, m1, re1, "ABERTO", "Reclamacao",
					"Joao nao lavou as vasilhas essa semana", data, null, false, 0));
			Feedback f2 = feedbackRepository.save(new Feedback(2L, m2, re1, "ABERTO", "Sugestao",
					"Comprar uma nova mesa de jantar", data, null, true, 0));

			ReceitaDespesa rd1 = receitaDespesaRepository.save(new ReceitaDespesa(1L, re1, "Despesa", "Conta de Água",
					(float) 30.0, "Mensal", true, (float) 10.0, d, d, true));
			ReceitaDespesa rd2 = receitaDespesaRepository.save(new ReceitaDespesa(2L, re1, "Receita", "Conta de Água",
					(float) 45.0, "Mensal", true, (float) 10.0, d, d, true));
			ReceitaDespesa rd3 = receitaDespesaRepository.save(new ReceitaDespesa(3L, re1, "Despesa", "Conta de Água",
					(float) 36.0, "Mensal", true, (float) 10.0, d, d, true));
			ReceitaDespesa rd4 = receitaDespesaRepository.save(new ReceitaDespesa(4L, re1, "Receita", "Conta de Água",
					(float) 47.0, "Mensal", true, (float) 10.0, d, d, true));
			ReceitaDespesa rd5 = receitaDespesaRepository.save(new ReceitaDespesa(5L, re2, "Despesa", "Conta de Água",
					(float) 31.0, "Mensal", true, (float) 10.0, d, d, true));

			moradorReceitaDespesaRepository.save(new MoradorReceitaDespesa(m1, rd1, 10, 0));
			moradorReceitaDespesaRepository.save(new MoradorReceitaDespesa(m3, rd1, 10, 0));
			moradorReceitaDespesaRepository.save(new MoradorReceitaDespesa(m4, rd1, 10, 0));

			Historico h1 = historicoRepository.save(new Historico(1L, "Carandiru", d, d, m1));
			Historico h2 = historicoRepository.save(new Historico(2L, "Disneylandia", d, d, m1));
			Historico h3 = historicoRepository.save(new Historico(3L, "Carandiru", d, d, m2));
			
			Usuario u1 = usuarioRepository.save(new Usuario(1L, "astolfo", "1234", m1));
			Usuario u2 = usuarioRepository.save(new Usuario(2L, "seilavei", "1234", m2));
			u1.setAtivo(true);
			/*
			 * republicaService.save(new Republica(2L, "Ilha da macacada", "Rua 4, nº 30",
			 * (byte) 3, "Casa", "Masculina", "Mateus, João", (byte) 3,
			 * "Cafeteira, Omeleteira, Fogão, Geladeira", "Sinuca", (byte) 1,
			 * "Rock todo final de semana", r2, "-"));
			 * 
			 * republicaService.save(new Republica(3L, "Filhos do Stewart",
			 * "Rua Miguel de Assis, nº 5", (byte) 4, "Apartamento", "Feminina",
			 * "Natália, Roberta, Marcela", (byte) 4,
			 * "Microondas, Fogão, Geladeira, Máquina de lavar roupa",
			 * "Secador de cabelo, chapinha", (byte) 1, "-", r3, "-"));
			 * 
			 * republicaService.save(new Republica(4L, "Cachorrão", "Rua Jucelino, nº 99",
			 * (byte) 5, "Apartamento", "Masculina", "Amaral, Breno, Pedro, Julio", (byte)
			 * 5, "Microondas, Fogão, Geladeira", "XBOX, Totó, Som", (byte) 0, "-", r4,
			 * "-"));
			 * 
			 * republicaService.save(new Republica(5L, "Saara", "Rua Ulices Junior, nº 50",
			 * (byte) 3, "Casa", "Feminina", "Bruna, Fernanda", (byte) 3,
			 * "Microondas, Fogão, Geladeira", "-", (byte) 0, "-", r5, "-"));
			 */

		};
	}

}
