package com.fullstack.cliente.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fullstack.cliente.modelo.Cliente;
import com.fullstack.cliente.modelo.ServicoPrestado;
import com.fullstack.cliente.modelo.ServicoPrestadoDTO;
import com.fullstack.cliente.repository.ClienteRepository;
import com.fullstack.cliente.repository.ServicoPrestadoRepository;
import com.fullstack.util.Util;

@Service
public class ServicoPrestadoService {
	
	@Autowired
	private ServicoPrestadoRepository repository;
	@Autowired
	private ClienteRepository clienteRepository ;
    


	public List<ServicoPrestado> findAll() {
		return repository.findAll();
	}
	
	
	
	public Optional<ServicoPrestado> findById(Long id) {
		 Optional<ServicoPrestado> obj = repository.findById(id);
			 return obj;
	}
	
	
	public List<ServicoPrestado> findByNomeClienteAndMes(String nome, Integer mes) {
		List<ServicoPrestado> obj = repository.findByNomeClienteAndMes(nome,mes);
		 return obj; 
	}

 
	
	
	

	 
	
 public ServicoPrestado insert (ServicoPrestadoDTO dto) throws ParseException {
		 
	     String descricao = dto.getDescricao(); 
	     SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
	     Date data = formato.parse(dto.getData());
	     Long idCliente = dto.getIdCliente();
	     Cliente obj = clienteRepository.findById(idCliente).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Não Encontrado"));
        
         BigDecimal valor = new BigDecimal(Util.converte(dto.getPreco())).setScale(2, RoundingMode.HALF_EVEN);
         
         ServicoPrestado servicoPrestado = new ServicoPrestado();
         
         servicoPrestado.setDescricao(descricao);
         servicoPrestado.setCliente(obj);
         servicoPrestado.setValor(valor);
         servicoPrestado.setData(data);
          
         return repository.save(servicoPrestado);
       
          
	}
 
	
	public void delete (Long id) {
		 repository.deleteById(id);
	}
	
	 
}
