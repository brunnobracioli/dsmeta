package com.devsuperior.dsmeta.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<Venda> buscarVendas(
			@RequestParam(value = "minData", defaultValue = "") String minData, 
			@RequestParam(value = "maxData", defaultValue = "")String maxData, 
			Pageable pageable) {
		return servico.buscarVendas(minData, maxData, pageable);
		
	}

}
