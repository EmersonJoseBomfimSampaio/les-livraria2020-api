package com.les.livraria.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.les.livraria.api.entities.Cliente;
import com.les.livraria.api.repositories.ClienteRepository;
import com.les.livraria.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Cliente persistir(Cliente cliente) {
		log.info("Persistindo cliente: {}", cliente);
		return this.clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscarPorCpf(String cpf) {
		log.info("Buscando cliente pelo CPF {}", cpf);
		return Optional.ofNullable(this.clienteRepository.findByCpf(cpf));
	}
	
	public Optional<Cliente> buscarPorEmail(String email) {
		log.info("Buscando cliente pelo email {}", email);
		return Optional.ofNullable(this.clienteRepository.findByEmail(email));
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		log.info("Buscando cliente pelo IDl {}", id);
		return Optional.ofNullable(this.clienteRepository.findById(id).get());
	}

}
