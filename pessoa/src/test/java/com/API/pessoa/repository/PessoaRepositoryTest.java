package com.API.pessoa.repository;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.PessoaRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaRepositoryTest {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@BeforeAll
	void start() {
	
		/*
		 * Inicializando quatro Objetos do tipo pessoa no Banco de dados de Teste
		 * */
		LocalDate data = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("01/02/2020");
		String dataFormatada = data.format(formatter);
		pessoaRepository.save( new Pessoa(0L, "Tulio Da Silva", data));
		
		LocalDate data1 = LocalDate.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("01/03/2021");
		String dataFormatada1 = data1.format(formatter1);
		pessoaRepository.save( new Pessoa(0L, "Dandara Da Silva", data1));
		
		LocalDate data2 = LocalDate.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("08/03/2021");
		String dataFormatada2 = data2.format(formatter1);
		pessoaRepository.save( new Pessoa(0L, "Adriana Da Silva ", data2));
		

		LocalDate data3 = LocalDate.now();
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("08/03/2021");
		String dataFormatada3 = data3.format(formatter1);
		pessoaRepository.save( new Pessoa(0L, "Tulio", data3));
		
	
		
		
	}
		
	@Test
	@DisplayName("Retorna 1 pessoa")
	@Order(1)
	public void deveRetornarUmaPessoa() {
		
    	Optional<Pessoa> pessoa = pessoaRepository.findByNome("Tulio");
    	assertTrue(pessoa.get().getNome().equals("Tulio"));
	}

	
	@Test
	@DisplayName("Retorna 3 pessoas")
	@Order(2)
	public void deveRetornarTresPessoas() {
		
		List<Pessoa> listaDePessoas = pessoaRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3,listaDePessoas.size());
		assertTrue(listaDePessoas.get(0).getNome().equals("Tulio Da Silva"));
		assertTrue(listaDePessoas.get(1).getNome().equals("Dandara Da Silva"));
		
		
	}
	

}
