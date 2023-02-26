package com.gendra.inventario.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.gendra.inventario.model.TCliente;
import com.gendra.inventario.repository.IClientesRepository;
import com.gendra.inventario.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClientesRepository clientesRepository;

	@Override
	public List<TCliente> list() {
		return clientesRepository.findAll();
	}

	@Override
	public TCliente save(TCliente cliente) {
		return clientesRepository.save(cliente);
	}

	@Override
	public void delete(Long idCliente) {
		clientesRepository.deleteById(idCliente);

	}

	@Override
	public TCliente update(TCliente cliente) throws NotFoundException {
		if(cliente.getIdTClientes() != null && clientesRepository.findById(cliente.getIdTClientes()).isPresent()) {
			return clientesRepository.save(cliente);
		}else {
			throw new NotFoundException();
		}
	}

}
