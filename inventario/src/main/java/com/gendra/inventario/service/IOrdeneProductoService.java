package com.gendra.inventario.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.gendra.inventario.model.TOrdenProducto;

public interface IOrdeneProductoService {
	
	List<TOrdenProducto> list();
	TOrdenProducto save(TOrdenProducto ordenProducto);
	TOrdenProducto update(TOrdenProducto ordenProducto) throws NotFoundException;
	void delete(Long idTOrdenProductos);

}
