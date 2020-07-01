package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.document.Curso;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ICursoRepo;
import com.mitocode.service.ICursoService;

import reactor.core.publisher.Flux;

@Service
public class CursoServiceImpl extends ICRUDImpl<Curso, String> implements ICursoService {

	@Autowired
	private ICursoRepo repo;
	
	@Override
	protected IGenericRepo<Curso, String> getRepo(){
		return repo;
	}
	
	@Override
	public Flux<Curso> buscarPorNombre(String nombre) {
		return repo.findByNombre(nombre);
	}
	
	
	/*@Override
	public Mono<Curso> registrar(Curso t) {
		return repo.save(t);
	}

	@Override
	public Mono<Curso> modificar(Curso t) {
		return repo.save(t);
	}

	@Override
	public Flux<Curso> listar() {
		return repo.findAll();		
	}

	@Override
	public Mono<Curso> listarPorId(String v) {
		return repo.findById(v);
	}

	@Override
	public Mono<Void> eliminar(String v) {	
		return this.repo.findById(v)
				.flatMap(curso -> repo.deleteById(v));

	}*/

}
