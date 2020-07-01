package com.mitocode.service;

import com.mitocode.document.Curso;

import reactor.core.publisher.Flux;

public interface ICursoService extends ICRUD<Curso, String>{

	Flux<Curso> buscarPorNombre(String nombre);

}
