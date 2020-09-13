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

import com.les.livraria.api.entities.Telefone;
import com.les.livraria.api.repositories.TelefoneRepository;
import com.les.livraria.api.services.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService{
	
	private static final Logger log = LoggerFactory.getLogger(TelefoneServiceImpl.class);

	@Autowired
	private TelefoneRepository telefoneRepository;

	public Page<Telefone> buscarPorFuncionarioId(Long clienteId, PageRequest pageRequest) {
		log.info("Buscando telefones para o cliente ID {}", clienteId);
		return this.telefoneRepository.findByClienteId(clienteId, pageRequest);
	}
	
	@Cacheable("telefonePorId")
	public Optional<Telefone> buscarPorId(Long id) {
		log.info("Buscando um telefone pelo ID {}", id);
		return Optional.ofNullable(this.telefoneRepository.findById(id).get());
	}
	
	@CachePut("telefonePorId")
	public Telefone persistir(Telefone telefone) {
		log.info("Persistindo o telefone: {}", telefone);
		return this.telefoneRepository.save(telefone);
	}
	
	public void remover(Long id) {
		log.info("Removendo o telefone ID {}", id);
		this.telefoneRepository.deleteById(id);
	}
	

}
