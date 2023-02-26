package com.gendra.inventario.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.gendra.inventario.model.TProducto;

public interface IProductoService {
	
	List<TProducto> list();
	TProducto save(TProducto producto);
	TProducto update(TProducto producto) throws NotFoundException;
	void delete(Long idProducto);

}
