package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionCallback;
import org.springframework.transaction.reactive.TransactionalOperator;

import com.mitocode.document.Matricula;
import com.mitocode.document.Curso;
import com.mitocode.repo.IMatriculaRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ICursoRepo;
import com.mitocode.service.IMatriculaService;

import reactor.core.publisher.Mono;

@Service
public class MatriculaServiceImpl extends ICRUDImpl<Matricula, String> implements IMatriculaService{

	@Autowired
	private IMatriculaRepo repo;
	
	@Autowired
	private ICursoRepo pRepo;
	
	/*@Autowired
	private TransactionalOperator txo;*/
	
	@Override
	protected IGenericRepo<Matricula, String> getRepo(){
		return repo;
	}
	
	@Override
	public Mono<Matricula> registrarTransaccional(Matricula f) throws Exception{
		Curso p = new Curso();		
		p.setEstado(true);
		p.setNombre("Spring Reactivo v2");
		p.setSiglas("SR2");
		
		Curso p2 = new Curso();		
		p2.setEstado(true);
		p2.setNombre("Spring Reactivo");
		p2.setSiglas("SR");
		
		/*this.txo.execute(new TransactionCallback<Matricula>() {
			@Override
			public Publisher<Matricula> doInTransaction(ReactiveTransaction status) {				
				return repo.save(f);
			}
		});*/
		
		//return this.txo.execute(status -> pRepo.save(p)).then(pRepo.save(p2)).then(repo.save(f));
		return null;
	}	

	
	
}
