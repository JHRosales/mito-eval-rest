package com.mitocode.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.document.Estudiante;
import com.mitocode.repo.IEstudianteRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEstudianteService;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;

import reactor.core.publisher.Flux;

@Service
public class EstudianteServiceImpl extends ICRUDImpl<Estudiante, String> implements IEstudianteService{

	@Autowired
	private IEstudianteRepo repo;
	
	@Override
	protected IGenericRepo<Estudiante, String> getRepo(){
		return repo;
	}
	
	@Override
	public Flux<Estudiante> findAllOrderByEdadDesc() {
		return repo.findAll(Sort.by(new Order(Direction.DESC, "edad")));
	}
	
	@Override
	public Flux<Estudiante> listarDemorado() {
		return repo.findAll().repeat(10).delayElements(Duration.ofSeconds(1));
	}

	
}
