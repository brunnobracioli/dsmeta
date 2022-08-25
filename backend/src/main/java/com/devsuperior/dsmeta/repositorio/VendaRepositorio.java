package com.devsuperior.dsmeta.repositorio;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entidades.Venda;

//Responsável por acessar os recursos do banco de dados. Salvar, deletar, buscar etc...
public interface VendaRepositorio extends JpaRepository <Venda, Long> {
	
	//Comando que utiliza a linguagem JPQL, sendo parecida com o SQL, porem está adaptada para ficar aderente ao banco de dados JPA.
	@Query("SELECT obj FROM Venda obj WHERE obj.data BETWEEN :min AND :max ORDER BY obj.quantiaVendida DESC")
	Page<Venda> buscarVendas(LocalDate min, LocalDate max, Pageable pageable);
}

