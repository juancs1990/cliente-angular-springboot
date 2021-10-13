package com.fullstack.cliente.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fullstack.cliente.modelo.Cliente;
import com.fullstack.cliente.services.ClienteService;

@RequestMapping(value="/clientes")
@RestController
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	 @GetMapping
	    public ResponseEntity<List<Cliente>> findAll() {
	        return ResponseEntity.ok(service.findAll());
	    }
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Cliente> findById(@PathVariable  Long id) {
			Cliente obj = service.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Não Encontrado"));
			return ResponseEntity.ok().body(obj);
		}
	 
	 @RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET)
		public ResponseEntity<Cliente> findByCpf(@PathVariable  String cpf) {
			Cliente obj = service.findByCpf(cpf) ;
			return ResponseEntity.ok().body(obj);
		}
	 
	 
	    @PostMapping
 		public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente cliente) {
	    	cliente = service.insert(cliente);
	    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).body(cliente);
 			 
		}
	 
	 
	 @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
		public ResponseEntity<Cliente> update(@RequestBody @Valid Cliente cliente, @PathVariable Long id ) {
		    cliente.setId(id);
		    Cliente obj =  service.update(cliente).orElseThrow(() ->  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cliente Não Encontrado"));
		    return ResponseEntity.ok().body(obj);
		}
	 
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
			
		}
		
		
		
	

}
