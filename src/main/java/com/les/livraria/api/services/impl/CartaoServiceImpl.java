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

import com.les.livraria.api.entities.Cartao;
import com.les.livraria.api.repositories.CartaoRepository;
import com.les.livraria.api.services.CartaoService;

@Service
public class CartaoServiceImpl implements CartaoService{
	
	private static final Logger log = LoggerFactory.getLogger(CartaoServiceImpl.class);

	@Autowired
	private CartaoRepository cartaoRepository;

	public Page<Cartao> buscarPorFuncionarioId(Long clienteId, PageRequest pageRequest) {
		log.info("Buscando cartões para o cliente ID {}", clienteId);
		return this.cartaoRepository.findByClienteId(clienteId, pageRequest);
	}
	
	@Cacheable("cartaoPorId")
	public Optional<Cartao> buscarPorId(Long id) {
		log.info("Buscando um cartão pelo ID {}", id);
		return Optional.ofNullable(this.cartaoRepository.findById(id).get());
	}
	
	@CachePut("cartaoPorId")
	public Cartao persistir(Cartao cartao) {
		log.info("Persistindo o cartão: {}", cartao);
		return this.cartaoRepository.save(cartao);
	}
	
	public void remover(Long id) {
		log.info("Removendo o cartão ID {}", id);
		this.cartaoRepository.deleteById(id);
	}
}
