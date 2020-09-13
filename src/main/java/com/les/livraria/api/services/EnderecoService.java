package com.les.livraria.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.les.livraria.api.entities.Endereco;

public interface EnderecoService {
	
	/**
	 * Retorna uma lista paginada de endereços de um determinado funcionário.
	 * 
	 * @param clienteId
	 * @param pageRequest
	 * @return Page<Endereco>
	 */
	Page<Endereco> buscarPorFuncionarioId(Long clienteId, PageRequest pageRequest);
	
	/**
	 * Retorna um endereço por ID.
	 * 
	 * @param id
	 * @return Optional<Endereco>
	 */
	Optional<Endereco> buscarPorId(Long id);
	
	/**
	 * Persiste um endereço na base de dados.
	 * 
	 * @param endereco
	 * @return Endereco
	 */
	Endereco persistir(Endereco endereco);
	
	/**
	 * Remove um endereço da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);

}
