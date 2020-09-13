package com.les.livraria.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.les.livraria.api.entities.Cartao;

@NamedQueries({
	@NamedQuery(name = "CartaoRepository.findByClienteId", 
			query = "SELECT cart FROM Cartao cart WHERE cart.cliente.id = :clienteId") })
public interface CartaoRepository extends JpaRepository<Cartao, Long>{
	
	List<Cartao> findByClienteId(@Param("clienteId") Long clienteId);
	
	Page<Cartao> findByClienteId(@Param("clienteId") Long clienteId, Pageable pageable);

}
