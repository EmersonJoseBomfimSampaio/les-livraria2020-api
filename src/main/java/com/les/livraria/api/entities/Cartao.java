package com.les.livraria.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.les.livraria.api.enums.Bandeira;

@Entity
@Table(name = "cartao")
public class Cartao implements Serializable{
	
	private static final long serialVersionUID = 9073097442478492108L;
	
	private String id;
	private String nomeCartao;
	private Bandeira bandeira;
	private Integer numero;
	private Date validade;
	private Integer cvv;
	private Cartao cartao;
	
	public Cartao() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "nome_cartao", nullable = false)
	public String getNomeCartao() {
		return nomeCartao;
	}
	
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	
	@Column(name = "bandeira", nullable = false)
	public Bandeira getBandeira() {
		return bandeira;
	}
	
	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	
	@Column(name = "numero", nullable = false)
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	@Column(name = "validade", nullable = false)
	public Date getValidade() {
		return validade;
	}
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	@Column(name = "cvv", nullable = false)
	public Integer getCvv() {
		return cvv;
	}
	
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Cartao getCartao() {
		return cartao;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
}
