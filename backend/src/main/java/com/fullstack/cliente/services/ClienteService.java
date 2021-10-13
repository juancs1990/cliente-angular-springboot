package com.fullstack.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fullstack.cliente.modelo.Cliente;
import com.fullstack.cliente.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	public Optional<Cliente> findById(Long id) {
		 Optional<Cliente> obj = repository.findById(id);
			 return obj;
	}
	
	public  Cliente findByCpf(String Cpf) {
		  Cliente obj = repository.findByCpf(Cpf);
			 return obj;
	}


	 
	public Cliente insert (Cliente cliente) {
		return repository.save(cliente);
	}
	
	public void delete (Long id) {
		  findById(id).orElseThrow((() ->  new NullPointerException("Cliente não Encontrado")));
	      repository.deleteById(id);
	}
	
	public void updateData (Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
	}
	
	public Optional<Cliente>  update(Cliente obj) {
		 Cliente  newObj = findById(obj.getId()).orElseThrow((() ->  new NullPointerException("Cliente não Encontrado")));
		updateData(newObj, obj);
		 repository.save(newObj);
		 Optional<Cliente> obj2 = repository.findById(newObj.getId());
		 return obj2;
		 
		}
	
	
	
}
