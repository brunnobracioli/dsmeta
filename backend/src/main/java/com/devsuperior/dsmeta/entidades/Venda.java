package com.devsuperior.dsmeta.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeVendedor;
	private Integer visita;
	private Integer venda;
	private Double quantiaVendida;
	private LocalDate data;
	
	public Venda() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Integer getVisita() {
		return visita;
	}

	public void setVisita(Integer visita) {
		this.visita = visita;
	}

	public Integer getVenda() {
		return venda;
	}

	public void setVenda(Integer venda) {
		this.venda = venda;
	}

	public Double getQuantiaVendida() {
		return quantiaVendida;
	}

	public void setQuantiaVendida(Double quantiaVendida) {
		this.quantiaVendida = quantiaVendida;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

}
