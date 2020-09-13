package com.les.livraria.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.les.livraria.api.entities.Endereco;
import com.les.livraria.api.repositories.EnderecoRepository;
import com.les.livraria.api.services.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	private static final Logger log = LoggerFactory.getLogger(EnderecoServiceImpl.class);

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Page<Endereco> buscarPorFuncionarioId(Long clienteId, PageRequest pageRequest) {
		log.info("Buscando endereços para o cliente ID {}", clienteId);
		return this.enderecoRepository.findByClienteId(clienteId, pageRequest);
	}
	
	@Cacheable("enderecoPorId")
	public Optional<Endereco> buscarPorId(Long id) {
		log.info("Buscando um endereço pelo ID {}", id);
		return Optional.ofNullable(this.enderecoRepository.findById(id).get());
	}
	
	@CachePut("enderecoPorId")
	public Endereco persistir(Endereco endereco) {
		log.info("Persistindo o endereço: {}", endereco);
		return this.enderecoRepository.save(endereco);
	}
	
	public void remover(Long id) {
		log.info("Removendo o endereço ID {}", id);
		this.enderecoRepository.deleteById(id);
	}
}
