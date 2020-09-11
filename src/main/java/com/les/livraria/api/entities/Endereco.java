package com.les.livraria.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.les.livraria.api.enums.TipoEndereco;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 8225204845081075109L;
	
	private String nome;
	private String tipoResidencia;
	private String tipoLogradouro;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	private String observacao;
	private TipoEndereco tipoEndereco;
	
	public Endereco() {
	}
	
}
