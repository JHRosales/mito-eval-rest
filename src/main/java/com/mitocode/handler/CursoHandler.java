package com.mitocode.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mitocode.document.Curso;
import com.mitocode.dto.ValidacionDTO;
import com.mitocode.service.ICursoService;
import com.mitocode.validators.RequestValidator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class CursoHandler {

	@Autowired
	private ICursoService service;
	
	@Autowired
	private Validator validador;
	
	@Autowired
	private RequestValidator validadorGeneral;
	
	public Mono<ServerResponse> listar(ServerRequest req){	
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.listar(), Curso.class);		
	}
	
	public Mono<ServerResponse> listarPorId(ServerRequest req){
		String id = req.pathVariable("id");
		return service.listarPorId(id)
				.flatMap(p -> ServerResponse
								.ok()
								.contentType(MediaType.APPLICATION_JSON)
								.body(fromValue(p))
				)				
				.switchIfEmpty(ServerResponse
							.notFound()
							.build()
				);
	}
	
	public Mono<ServerResponse> registrar(ServerRequest req){
		
		Mono<Curso> cursoMono = req.bodyToMono(Curso.class);
		
		/*return cursoMono.flatMap(p -> {
			Errors errores = new BeanPropertyBindingResult(p, Curso.class.getName());
			validador.validate(p, errores);
			
			if(errores.hasErrors()) {
				return Flux.fromIterable(errores.getFieldErrors())
						.map(error -> new ValidacionDTO(error.getField(), error.getDefaultMessage()))						
						.collectList()
						.flatMap(listaErrores -> {							
							return ServerResponse.badRequest()
									.contentType(MediaType.APPLICATION_JSON)
									.body(fromValue(listaErrores));	
									}
								); 
			}else {
				return service.registrar(p).flatMap(pdb -> ServerResponse
						.created(URI.create(req.uri().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(fromValue(pdb))
						);
			}
			
		});*/
		
		/*return cursoMono.flatMap(p-> {
			return service.registrar(p);
		}).flatMap(p -> ServerResponse.created(URI.create(req.uri().toString().concat("/").concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(p)));*/
		
		return cursoMono
				.flatMap(this.validadorGeneral::validate) //p -> this.validadorGeneral.validate((p)
				.flatMap(p-> service.registrar(p))
				.flatMap(p -> ServerResponse.created(URI.create(req.uri().toString().concat("/").concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(p)));
	}
	
	public Mono<ServerResponse> modificar(ServerRequest req){
		
		Mono<Curso> cursoMono = req.bodyToMono(Curso.class);
		
		return cursoMono.flatMap(p-> {
			return service.modificar(p);
		}).flatMap(p -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(p)));
	}
	
	public Mono<ServerResponse> eliminar(ServerRequest req){
		String id = req.pathVariable("id");
		
		return service.listarPorId(id)
				.flatMap(p -> service.eliminar(p.getId())
				.then(ServerResponse
						.noContent()
						.build()
				)
				.switchIfEmpty(ServerResponse
						.notFound()
						.build()
				)
			);
	}
	
	
}
