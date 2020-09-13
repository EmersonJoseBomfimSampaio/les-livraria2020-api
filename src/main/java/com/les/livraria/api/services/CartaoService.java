package com.les.livraria.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.les.livraria.api.entities.Cartao;

public interface CartaoService {
	
	/**
	 * Retorna uma lista paginada de cartões de um determinado cliente.
	 * 
	 * @param clienteId
	 * @param pageRequest
	 * @return Page<Cartao>
	 */
	Page<Cartao> buscarPorFuncionarioId(Long clienteId, PageRequest pageRequest);
	
	/**
	 * Retorna um cartão por ID.
	 * 
	 * @param id
	 * @return Optional<Cartao>
	 */
	Optional<Cartao> buscarPorId(Long id);
	
	/**
	 * Persiste um cartão na base de dados.
	 * 
	 * @param cartao
	 * @return Cartao
	 */
	Cartao persistir(Cartao cartao);
	
	/**
	 * Remove um cartão da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);

}
