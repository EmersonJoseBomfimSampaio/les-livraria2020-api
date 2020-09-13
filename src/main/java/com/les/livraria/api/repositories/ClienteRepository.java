package com.les.livraria.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.les.livraria.api.entities.Cliente;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByCpf(String cpf);
	
	Cliente findByEmail(String email);
	
	Cliente findByCpfOrEmail(String cpf, String email);

}
