package com.les.livraria.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.les.livraria.api.entities.Telefone;

@NamedQueries({
	@NamedQuery(name = "TelefoneRopository.findByClienteId", 
			query = "SELECT tele FROM Telefone tele WHERE tele.cliente.id = :clienteId") })
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	List<Telefone> findByClienteId(@Param("clienteId") Long clienteId);
	
	Page<Telefone> findByClienteId(@Param("clienteId") Long clienteId, Pageable pageable);

}