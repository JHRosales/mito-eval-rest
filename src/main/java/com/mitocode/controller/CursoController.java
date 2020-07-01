package com.mitocode.controller;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static reactor.function.TupleUtils.function;

import com.mitocode.document.Curso;
import com.mitocode.service.ICursoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	private static final Logger log = LoggerFactory.getLogger(CursoController.class);

	@Autowired
	private ICursoService service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Curso>>> listar(){
		Flux<Curso> fxCursos = service.listar();
		
		return Mono.just(ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(fxCursos));
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Curso>> listarPorId(@PathVariable("id") String id){
		return service.listarPorId(id) //Mono<Curso> || Mono<ResponseEntity<Curso>>
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(p)
				).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ResponseEntity<Curso>> registrar(@Valid @RequestBody Curso curso, final ServerHttpRequest req){
		//localhost:8080/cursos/1
		return service.registrar(curso)
				.map(p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(p)
				);
	}
	
	@PutMapping
	public Mono<ResponseEntity<Curso>> modificar(@Valid @RequestBody Curso curso){
		return service.modificar(curso)
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(p)
				).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable("id") String id){
		return service.listarPorId(id)
				.flatMap(p -> {
					return service.eliminar(p.getId())
							.then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
				})
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	private Curso cursoHateoas;
	
	@GetMapping("/hateoas/{id}")
	public Mono<EntityModel<Curso>> listarHateoasPorId(@PathVariable("id") String id){
		
		//link: localhost:8080/cursos/hateoas/123
		
		Mono<Link> selfLink1 = linkTo(methodOn(CursoController.class).listarHateoasPorId(id)).withSelfRel().toMono();
		Mono<Link> selfLink2 = linkTo(methodOn(CursoController.class).listarHateoasPorId(id)).withSelfRel().toMono();
		
		//CON VARIABLE GLOBAL
		/*return service.listarPorId(id)
				.flatMap(p -> {
					this.cursoHateoas = p;
					return selfLink;
				}).map(links -> {
					return new EntityModel<>(this.cursoHateoas, links);
				});
		*/
		
		/*return service.listarPorId(id).zipWith(selfLink1, (p, links) -> {
			return new EntityModel<>(p, links);
		});*/
		
		//CON MULTIPLE LINKS
		return selfLink1.zipWith(selfLink2)
				.map(function((left, right) -> Links.of(left, right)))
				.zipWith(service.listarPorId(id), (links, p) -> {
					return new EntityModel<>(p, links);		
				});	
		
	}
}
