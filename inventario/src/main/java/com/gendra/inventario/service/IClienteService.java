package com.gendra.inventario.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.gendra.inventario.model.TCliente;

public interface IClienteService {
	
	List<TCliente> list();
	TCliente save(TCliente cliente);
	TCliente update(TCliente cliente) throws NotFoundException;
	void delete(Long IdCliente);

}
