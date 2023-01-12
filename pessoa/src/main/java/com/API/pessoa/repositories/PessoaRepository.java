package com.API.pessoa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


import com.API.pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	/** 
	 * Método criado para a Sessão de testes
	 */ 
	
	
    public Optional<Pessoa>findByNome(String nome);  
    
    
  
    
    
	
	/** 
	 * Método criado para consultar  uma pessoa pelo nome
	 * no banco  dados
	 */ 
	
	public List <Pessoa> findAllByNomeContainingIgnoreCase(String nome);
	// select *  from tb_pessoa where nome  like "%nome%";
	
	

}
