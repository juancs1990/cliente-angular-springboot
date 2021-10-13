package com.fullstack.cliente.resources;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fullstack.cliente.modelo.Cliente;
import com.fullstack.cliente.modelo.ServicoPrestado;
import com.fullstack.cliente.modelo.ServicoPrestadoDTO;
import com.fullstack.cliente.services.ServicoPrestadoService;

@RequestMapping(value="/servicos-prestados")
@RestController
@ControllerAdvice
public class ServicoPrestadoResource {
	
	@Autowired
	ServicoPrestadoService service;
	 
	 @GetMapping
	    public ResponseEntity<List<ServicoPrestado>> findAll() {
	        return ResponseEntity.ok(service.findAll());
	    }
	    
	 
	/*
	  @RequestMapping( method = RequestMethod.GET, params={"nome","mes"})
	  public ResponseEntity<ServicoPrestado>   findByNomeClienteAndMes(
	    		@RequestParam(name="nome", required=false, defaultValue = "") String nome,
	    		@RequestParam(name="mes", required=false) Integer mes
	    		) {
		 ServicoPrestado obj = service.findByNomeClienteAndMes(nome,mes).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Não Encontrado"));

	        return ResponseEntity.ok(obj);
	    }
	*/
	 
	  @RequestMapping(
			  value = "", 
			  params = { "nome", "mes" }, 
			  method = RequestMethod.GET)
	   @ResponseBody	   
	   public ResponseEntity<List<ServicoPrestado>> findByNomeClienteAndMes(
			   @RequestParam (name="nome", required=false, defaultValue = "") String nome,  @RequestParam (name="mes", required=false) Integer mes)
            {
		    return ResponseEntity.ok(service.findByNomeClienteAndMes(nome,mes));
	       }
	 
	 
	  
 
  
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
		public ServicoPrestado insert(@Valid @RequestBody ServicoPrestadoDTO servico) throws ParseException {
			 return service.insert(servico);
		}
	 
	 
	 
	/* @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
		public ResponseEntity<ServicoPrestado> update(@RequestBody @Valid ServicoPrestado cliente, @PathVariable Long id ) {
		    cliente.setId(id);
		    ServicoPrestado obj =  service.update(cliente).orElseThrow(() ->  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ServicoPrestado Não Encontrado"));
		    return ResponseEntity.ok().body(obj);
		}
	*/
	    
	 
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
			
		}
		
		
		
	

}
