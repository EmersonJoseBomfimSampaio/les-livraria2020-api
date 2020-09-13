package com.les.livraria.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.les.livraria.api.entities.Endereco;

@NamedQueries({
	@NamedQuery(name = "EnderecoRepository.findByClienteId", 
			query = "SELECT ende FROM Endereco ende WHERE ende.cliente.id = :clienteId") })
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByClienteId(@Param("clienteId") Long clienteId);
	
	Page<Endereco> findByClienteId(@Param("clienteId") Long clienteId, Pageable pageable);

}
