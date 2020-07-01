<p align="center"><img src="https://miro.medium.com/max/705/1*jN41v5TFycg9luCOB8w6cA.png"></p>

<p align="center">
<a href="https://travis-ci.org/laravel/framework"><img src="https://travis-ci.org/laravel/framework.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/license.svg" alt="License"></a>
</p>

# Academia

Consideraciones técnicas:
 * MongoDB 4.x+
 * Enfoque de Anotaciones y Funcional Endpoints para la creación de los servicios.
 * Control de excepciones globales 
 * Se protege todos los endpoints con Spring Security + JWT 
 * Solo con tokens vigentes se podrá consumir servicios.



## Installing / Getting started

En el `pom.xml` se comentó una dependencia, para que funicione con el framework, en algunos casos es necesario descomentar esa dependencia

```shell
	<!-- <dependency>
            <groupId>org.springframework.plugin</groupId>
            <artifactId>spring-plugin-core</artifactId>
            <version>1.2.0.RELEASE</version>
        </dependency>-->
```

### Initial Configuration

Se crea los servicios REST para 
* CRUD Estudiantes 
 	* Id: string 
	* Nombres: string 
	* Apellidos: string 
	* DNI: string 
	* Edad: double 
* CRUD Cursos 
	* Id: string 
	* Nombre: string 
	* Siglas: string 
	* Estado: boolean 
* Registrar Matricula 
   Comprende un documento dentro de una colección NOSQL que brinde la siguiente información. 
	* Fecha Mátricula: TimeStamp | LocalDateTime 
	* Estudiante | Class 
	* Cursos: [ ref:1, ref2. etc… ] | Array DbRef 
	* Estado: boolean
	
En MongoDB:
Se crea una base de Datos llamada: `academia`.
En el proyecto se adjunta los archivos JSON de las colecciones "Tablas" de la BD `Academia\*`.

Se crea las siguientes tablas:

	* cursos
	* estudiantes
	* matriculas
	* roles
	* usuarios

## Developing

Here's a brief intro about what a developer must do in order to start developing
the project further:

```shell
cd awesome-project/
packagemanager install
```

And s.

## Features

A continuacion se detalla todas las funciones del servicio.

#### Curso Controller
<div class="no-margin"><!-- react-text: 150 --> <!-- /react-text --><span><div class="opblock opblock-get" id="operations-curso-controller-listarUsingGET"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/cursos"><a class="nostyle" href="#/curso-controller/listarUsingGET"><span>&#8203;/cursos</span></a></span><div class="opblock-summary-description">listar</div><!-- react-empty: 159 --></div><noscript></noscript></div></span><span><div class="opblock opblock-post" id="operations-curso-controller-registrarUsingPOST"><div class="opblock-summary opblock-summary-post"><span class="opblock-summary-method">POST</span><span class="opblock-summary-path" data-path="/cursos"><a class="nostyle" href="#/curso-controller/registrarUsingPOST"><span>&#8203;/cursos</span></a></span><div class="opblock-summary-description">registrar</div><!-- react-empty: 169 --></div><noscript></noscript></div></span><span><div class="opblock opblock-put" id="operations-curso-controller-modificarUsingPUT"><div class="opblock-summary opblock-summary-put"><span class="opblock-summary-method">PUT</span><span class="opblock-summary-path" data-path="/cursos"><a class="nostyle" href="#/curso-controller/modificarUsingPUT"><span>&#8203;/cursos</span></a></span><div class="opblock-summary-description">modificar</div><!-- react-empty: 179 --></div><noscript></noscript></div></span><span><div class="opblock opblock-get" id="operations-curso-controller-listarPorIdUsingGET"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/cursos/{id}"><a class="nostyle" href="#/curso-controller/listarPorIdUsingGET"><span>&#8203;/cursos&#8203;/{id}</span></a></span><div class="opblock-summary-description">listarPorId</div><!-- react-empty: 189 --></div><noscript></noscript></div></span><span><div class="opblock opblock-delete" id="operations-curso-controller-eliminarUsingDELETE"><div class="opblock-summary opblock-summary-delete"><span class="opblock-summary-method">DELETE</span><span class="opblock-summary-path" data-path="/cursos/{id}"><a class="nostyle" href="#/curso-controller/eliminarUsingDELETE"><span>&#8203;/cursos&#8203;/{id}</span></a></span><div class="opblock-summary-description">eliminar</div><!-- react-empty: 199 --></div><noscript></noscript></div></span><span><div class="opblock opblock-get" id="operations-curso-controller-listarHateoasPorIdUsingGET"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/cursos/hateoas/{id}"><a class="nostyle" href="#/curso-controller/listarHateoasPorIdUsingGET"><span>&#8203;/cursos&#8203;/hateoas&#8203;/{id}</span></a></span><div class="opblock-summary-description">listarHateoasPorId</div><!-- react-empty: 209 --></div><noscript></noscript></div></span><!-- react-text: 211 --> <!-- /react-text --></div>
	
#### Estudiante Controller
<div class="no-margin"><!-- react-text: 213 --> <!-- /react-text --><span><div class="opblock opblock-get" id="operations-estudiante-controller-listarUsingGET_1"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/estudiantes"><a class="nostyle" href="#/estudiante-controller/listarUsingGET_1"><span>&#8203;/estudiantes</span></a></span><div class="opblock-summary-description">listar</div><!-- react-empty: 222 --></div><noscript></noscript></div></span><span><div class="opblock opblock-post" id="operations-estudiante-controller-registrarUsingPOST_1"><div class="opblock-summary opblock-summary-post"><span class="opblock-summary-method">POST</span><span class="opblock-summary-path" data-path="/estudiantes"><a class="nostyle" href="#/estudiante-controller/registrarUsingPOST_1"><span>&#8203;/estudiantes</span></a></span><div class="opblock-summary-description">registrar</div><!-- react-empty: 232 --></div><noscript></noscript></div></span><span><div class="opblock opblock-put" id="operations-estudiante-controller-modificarUsingPUT_1"><div class="opblock-summary opblock-summary-put"><span class="opblock-summary-method">PUT</span><span class="opblock-summary-path" data-path="/estudiantes"><a class="nostyle" href="#/estudiante-controller/modificarUsingPUT_1"><span>&#8203;/estudiantes</span></a></span><div class="opblock-summary-description">modificar</div><!-- react-empty: 242 --></div><noscript></noscript></div></span><span><div class="opblock opblock-get" id="operations-estudiante-controller-listarPorIdUsingGET_1"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/estudiantes/{id}"><a class="nostyle" href="#/estudiante-controller/listarPorIdUsingGET_1"><span>&#8203;/estudiantes&#8203;/{id}</span></a></span><div class="opblock-summary-description">listarPorId</div><!-- react-empty: 252 --></div><noscript></noscript></div></span><span><div class="opblock opblock-delete" id="operations-estudiante-controller-eliminarUsingDELETE_1"><div class="opblock-summary opblock-summary-delete"><span class="opblock-summary-method">DELETE</span><span class="opblock-summary-path" data-path="/estudiantes/{id}"><a class="nostyle" href="#/estudiante-controller/eliminarUsingDELETE_1"><span>&#8203;/estudiantes&#8203;/{id}</span></a></span><div class="opblock-summary-description">eliminar</div><!-- react-empty: 262 --></div><noscript></noscript></div></span><!-- react-text: 264 --> <!-- /react-text --></div>

#### Login Controller
<div class="no-margin"><!-- react-text: 266 --> <!-- /react-text --><span><div class="opblock opblock-post" id="operations-login-controller-loginUsingPOST"><div class="opblock-summary opblock-summary-post"><span class="opblock-summary-method">POST</span><span class="opblock-summary-path" data-path="/login"><a class="nostyle" href="#/login-controller/loginUsingPOST"><span>&#8203;/login</span></a></span><div class="opblock-summary-description">login</div><!-- react-empty: 275 --></div><noscript></noscript></div></span><span><div class="opblock opblock-post" id="operations-login-controller-loginUsingPOST_1"><div class="opblock-summary opblock-summary-post"><span class="opblock-summary-method">POST</span><span class="opblock-summary-path" data-path="/v2/login"><a class="nostyle" href="#/login-controller/loginUsingPOST_1"><span>&#8203;/v2&#8203;/login</span></a></span><div class="opblock-summary-description">login</div><!-- react-empty: 285 --></div><noscript></noscript></div></span><!-- react-text: 287 --> <!-- /react-text --></div>

#### Matricula Controller
<div class="no-margin"><!-- react-text: 289 --> <!-- /react-text --><span><div class="opblock opblock-get" id="operations-matricula-controller-listarUsingGET_2"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/matriculas"><a class="nostyle" href="#/matricula-controller/listarUsingGET_2"><span>&#8203;/matriculas</span></a></span><div class="opblock-summary-description">listar</div><!-- react-empty: 298 --></div><noscript></noscript></div></span><span><div class="opblock opblock-post" id="operations-matricula-controller-registrarUsingPOST_2"><div class="opblock-summary opblock-summary-post"><span class="opblock-summary-method">POST</span><span class="opblock-summary-path" data-path="/matriculas"><a class="nostyle" href="#/matricula-controller/registrarUsingPOST_2"><span>&#8203;/matriculas</span></a></span><div class="opblock-summary-description">registrar</div><!-- react-empty: 308 --></div><noscript></noscript></div></span><span><div class="opblock opblock-put" id="operations-matricula-controller-modificarUsingPUT_2"><div class="opblock-summary opblock-summary-put"><span class="opblock-summary-method">PUT</span><span class="opblock-summary-path" data-path="/matriculas"><a class="nostyle" href="#/matricula-controller/modificarUsingPUT_2"><span>&#8203;/matriculas</span></a></span><div class="opblock-summary-description">modificar</div><!-- react-empty: 318 --></div><noscript></noscript></div></span><span><div class="opblock opblock-get" id="operations-matricula-controller-listarPorIdUsingGET_2"><div class="opblock-summary opblock-summary-get"><span class="opblock-summary-method">GET</span><span class="opblock-summary-path" data-path="/matriculas/{id}"><a class="nostyle" href="#/matricula-controller/listarPorIdUsingGET_2"><span>&#8203;/matriculas&#8203;/{id}</span></a></span><div class="opblock-summary-description">listarPorId</div><!-- react-empty: 328 --></div><noscript></noscript></div></span><span><div class="opblock opblock-delete" id="operations-matricula-controller-eliminarUsingDELETE_2"><div class="opblock-summary opblock-summary-delete"><span class="opblock-summary-method">DELETE</span><span class="opblock-summary-path" data-path="/matriculas/{id}"><a class="nostyle" href="#/matricula-controller/eliminarUsingDELETE_2"><span>&#8203;/matriculas&#8203;/{id}</span></a></span><div class="opblock-summary-description">eliminar</div><!-- react-empty: 338 --></div><noscript></noscript></div></span><!-- react-text: 340 --> <!-- /react-text --></div>

## Configuration

Here you should write what are all of the configurations a user can enter when
using the project.

#### Argument 1
Type: `String`  
Default: `'default value'`

State what an argument does and how you can use it. If needed, you can provide
an example below.

Example:
```bash
awesome-project "Some other value"  # Prints "You're nailing this readme!"
```

#### Argument 2
Type: `Number|Boolean`  
Default: 100

Copy-paste as many of these as you need.

## Contributing

When 

## Links

links like:

- Repository: https://github.com/JHRosales/mito-eval-rest
- MONGO DB 4.x+: https://www.mongodb.com/try/download/compass


## Licensing

This proyect is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT)

"Jhimi Rosales"
