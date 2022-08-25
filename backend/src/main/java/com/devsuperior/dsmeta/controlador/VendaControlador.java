package com.devsuperior.dsmeta.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entidades.Venda;
import com.devsuperior.dsmeta.servico.VendaServico;

//Controller, implementa a api, ele disponibiliza os endpoints que o frontend precisa para acessar o backend
@RestController
@RequestMapping(value = "/vendas")
public class VendaControlador {
	
	@Autowired
	private VendaServico servico;
	
	@GetMapping
	public List<Venda> buscarVendas() {
		return servico.buscarVendas();
		
	}

}
