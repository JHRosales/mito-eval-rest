package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mitocode.document.Usuario;
import com.mitocode.repo.IUsuarioRepo;

import reactor.core.publisher.Mono;

@Service
public class UserDetailsServiceImpl {/*implements ReactiveUserDetailsService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public Mono<UserDetails> findByUsername(String username) {
		Mono<Usuario> usuarioMono = repo.findOneByUsuario(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();		
		
		return usuarioMono.doOnNext(u -> {
			u.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getNombre())));
		}).flatMap(u -> {
			return Mono.just(new User(u.getUsuario(), u.getClave(), u.getEstado(), true, true, true, authorities));
		});
	}*/
}
