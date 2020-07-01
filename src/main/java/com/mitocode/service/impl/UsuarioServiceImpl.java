package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.document.Rol;
import com.mitocode.document.Usuario;
import com.mitocode.pagination.PageSupport;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IUsuarioRepo;
import com.mitocode.security.User;
import com.mitocode.service.IUsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl extends ICRUDImpl<Usuario, String> implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, String> getRepo() {
		return repo; 
	}
	
	
	@Override
	public Mono<User> buscarPorUsuario(String usuario) {
		Mono<Usuario> monoUsuario = repo.findOneByUsuario(usuario);

		List<String> roles = new ArrayList<String>();
				
		return monoUsuario.doOnNext(u -> {
			for (Rol role : u.getRoles()) {			
				roles.add(role.getNombre());
			}
		}).flatMap(u -> {
			return Mono.just(new User(u.getUsuario(), u.getClave(), u.getEstado(), roles));
		});
	}

}
