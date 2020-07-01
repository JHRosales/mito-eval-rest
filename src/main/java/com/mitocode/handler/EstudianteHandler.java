package com.mitocode.handler;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mitocode.document.Estudiante;
import com.mitocode.service.IEstudianteService;
import com.mitocode.validators.RequestValidator;

import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class EstudianteHandler {

	@Autowired
	private IEstudianteService service;
	
	@Autowired
	private RequestValidator validadorGeneral;
	
	public Mono<ServerResponse> listar(ServerRequest req){	
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.listar(), Estudiante.class);		
	}
	
	public Mono<ServerResponse> listarPorId(ServerRequest req){
		String id = req.pathVariable("id");
		return service.listarPorId(id)
				.flatMap(c -> ServerResponse
								.ok()
								.contentType(MediaType.APPLICATION_JSON)
								.body(fromValue(c))
				)				
				.switchIfEmpty(ServerResponse
							.notFound()
							.build()
				);
	}
	
	public Mono<ServerResponse> registrar(ServerRequest req){
		
		Mono<Estudiante> estudianteMono = req.bodyToMono(Estudiante.class);
		
		/*return estudianteMono.flatMap(c-> {
			return service.registrar(c);
		}).flatMap(c -> ServerResponse.created(URI.create(req.uri().toString().concat("/").concat(c.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(c)));
		*/
		return estudianteMono
				.flatMap(this.validadorGeneral::validate) //p -> this.validadorGeneral.validate((p)
				.flatMap(p-> service.registrar(p))
				.flatMap(p -> ServerResponse.created(URI.create(req.uri().toString().concat("/").concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(p)));
	}
	
	public Mono<ServerResponse> modificar(ServerRequest req){
		
		Mono<Estudiante> estudianteMono = req.bodyToMono(Estudiante.class);
		
		return estudianteMono.flatMap(c-> {
			return service.modificar(c);
		}).flatMap(c -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(c)));
	}
	
	public Mono<ServerResponse> eliminar(ServerRequest req){
		String id = req.pathVariable("id");
		
		return service.listarPorId(id)
				.flatMap(c -> service.eliminar(c.getId())
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
