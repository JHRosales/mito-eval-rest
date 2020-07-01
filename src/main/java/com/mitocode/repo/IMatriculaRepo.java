package com.mitocode.repo;

import org.springframework.data.mongodb.repository.Query;

import com.mitocode.document.Matricula;

import reactor.core.publisher.Flux;

public interface IMatriculaRepo extends IGenericRepo<Matricula, String>{
	
}
