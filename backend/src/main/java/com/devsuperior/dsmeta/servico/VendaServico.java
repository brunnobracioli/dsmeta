package com.devsuperior.dsmeta.servico;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entidades.Venda;
import com.devsuperior.dsmeta.repositorio.VendaRepositorio;

//Service, responsável por implementar operações de negocio do nosso interesse.
@Service
public class VendaServico {
	
	@Autowired
	private VendaRepositorio repositorio;
	
	public Page<Venda> buscarVendas(String minData, String maxData, Pageable pageable) {
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minData.equals("") ? hoje.minusDays(365) : LocalDate.parse(minData);
		LocalDate max = maxData.equals("") ? hoje : LocalDate.parse(maxData);
		
		return repositorio.buscarVendas(min, max, pageable);
	}

}

