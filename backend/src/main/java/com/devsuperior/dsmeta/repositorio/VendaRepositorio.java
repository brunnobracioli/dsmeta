package com.devsuperior.dsmeta.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entidades.Venda;

//Responsável por acessar os recursos do banco de dados. Salvar, deletar, buscar etc...
public interface VendaRepositorio extends JpaRepository <Venda, Long> {

	
}

