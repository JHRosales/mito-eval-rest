package com.mitocode.repo;

import org.springframework.data.mongodb.repository.Query;

import com.mitocode.document.Curso;

import reactor.core.publisher.Flux;

public interface ICursoRepo extends IGenericRepo<Curso, String>{

	//case insensitive
	@Query("{ 'nombre': {$regex : ?0, '$options': 'i' }}")
	Flux<Curso> findByNombre(String nombre);

}
