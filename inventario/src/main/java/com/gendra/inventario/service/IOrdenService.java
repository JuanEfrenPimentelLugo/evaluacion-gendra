package com.gendra.inventario.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.gendra.inventario.model.TOrdene;

public interface IOrdenService {
	
	List<TOrdene> list();
	TOrdene save(TOrdene orden);
	TOrdene update(TOrdene orden) throws NotFoundException;
	void delete(Long iOrden);

}
