package com.les.livraria.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.les.livraria.api.entities.Telefone;

public interface TelefoneService {
	
	/**
	 * Retorna uma lista paginada de telefones de um determinado funcionário.
	 * 
	 * @param clienteId
	 * @param pageRequest
	 * @return Page<Telefone>
	 */
	Page<Telefone> buscarPorFuncionarioId(Long clienteId, PageRequest pageRequest);
	
	/**
	 * Retorna um telefone por ID.
	 * 
	 * @param id
	 * @return Optional<Telefone>
	 */
	Optional<Telefone> buscarPorId(Long id);
	
	/**
	 * Persiste um telefone na base de dados.
	 * 
	 * @param telefone
	 * @return Telefone
	 */
	Telefone persistir(Telefone telefone);
	
	/**
	 * Remove um telefone da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);

}
