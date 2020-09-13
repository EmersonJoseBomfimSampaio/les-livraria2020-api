package com.les.livraria.api.services;

import java.util.Optional;

import com.les.livraria.api.entities.Cliente;

public interface ClienteService {
	
	/**
	 * Persiste um cliente na base de dados.
	 * 
	 * @param cliente
	 * @return Cliente
	 */
	Cliente persistir(Cliente cliente);
	
	/**
	 * Busca e retorna um cliente dado um CPF.
	 * 
	 * @param cpf
	 * @return Optional<Funcionario>
	 */
	Optional<Cliente> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retorna um cliente dado um email.
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 */
	Optional<Cliente> buscarPorEmail(String email);
	
	/**
	 * Busca e retorna um cliente por ID.
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 */
	Optional<Cliente> buscarPorId(Long id);

}
