package com.gendra.inventario.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.gendra.inventario.model.TProducto;
import com.gendra.inventario.repository.IProductosRepository;
import com.gendra.inventario.service.IProductoService;


@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	IProductosRepository productosRepository;

	@Override
	public List<TProducto> list() {
		return productosRepository.findAll();
	}

	@Override
	public TProducto save(TProducto producto) {
		return productosRepository.save(producto);
	}

	@Override
	public void delete(Long idProducto) {
		productosRepository.deleteById(idProducto);

	}

	@Override
	public TProducto update(TProducto producto) throws NotFoundException {
		if(producto.getIdTProductos() != null && productosRepository.findById(producto.getIdTProductos()).isPresent()) {
			return productosRepository.save(producto);
		}else {
			throw new NotFoundException();
		}
	}

}
