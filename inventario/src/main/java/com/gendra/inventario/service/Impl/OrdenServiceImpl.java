package com.gendra.inventario.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.gendra.inventario.model.TOrdene;
import com.gendra.inventario.repository.IOrdenesRepository;
import com.gendra.inventario.service.IOrdenService;

@Service
public class OrdenServiceImpl implements IOrdenService {
	
	@Autowired
	 IOrdenesRepository ordenesRepository;

	@Override
	public List<TOrdene> list() {
		return ordenesRepository.findAll();
	}

	@Override
	public TOrdene save(TOrdene orden) {
		return ordenesRepository.save(orden);
	}

	@Override
	public void delete(Long idOrden) {
		ordenesRepository.deleteById(idOrden);

	}

	@Override
	public TOrdene update(TOrdene orden) throws NotFoundException {
		if(orden.getIdTOrdenes() != null && ordenesRepository.findById(orden.getIdTOrdenes()).isPresent()) {
			return ordenesRepository.save(orden);
		}else {
			throw new NotFoundException();
		}
	}

}
