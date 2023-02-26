package com.gendra.inventario.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.gendra.inventario.model.TOrdenProducto;
import com.gendra.inventario.repository.IOrdenesProductosRepository;
import com.gendra.inventario.service.IOrdeneProductoService;

@Service
public class OrdenProductoServiceImpl implements IOrdeneProductoService {

	@Autowired
	IOrdenesProductosRepository ordenesProductosRepository;

	@Override
	public List<TOrdenProducto> list() {
		return ordenesProductosRepository.findAll();
	}

	@Override
	public TOrdenProducto save(TOrdenProducto ordenProducto) {
		return ordenesProductosRepository.save(ordenProducto);
	}

	@Override
	public void delete(Long idTOrdenProductos) {
		ordenesProductosRepository.deleteById(idTOrdenProductos);

	}

	@Override
	public TOrdenProducto update(TOrdenProducto ordenProducto) throws NotFoundException {
		if(ordenProducto.getIdTOrdenProductos() != null && ordenesProductosRepository.findById(ordenProducto.getIdTOrdenProductos()).isPresent()) {
			return ordenesProductosRepository.save(ordenProducto);
		}else {
			throw new NotFoundException();
		}
	}

}
