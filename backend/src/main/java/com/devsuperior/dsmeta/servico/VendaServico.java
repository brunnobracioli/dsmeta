package com.devsuperior.dsmeta.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entidades.Venda;
import com.devsuperior.dsmeta.repositorio.VendaRepositorio;

//Service, responsável por implementar operações de negocio do nosso interesse.
@Service
public class VendaServico {
	
	@Autowired
	private VendaRepositorio repositorio;
	
	public List<Venda> buscarVendas() {
		return repositorio.findAll();
	}

}

