package com.mitocode.service;

import org.springframework.data.domain.Pageable;

import com.mitocode.document.Matricula;
import com.mitocode.pagination.PageSupport;

import reactor.core.publisher.Mono;

public interface IMatriculaService extends ICRUD<Matricula, String>{
	
	Mono<Matricula> registrarTransaccional(Matricula f) throws Exception;
	Mono<PageSupport<Matricula>> listarPage(Pageable page);
}
