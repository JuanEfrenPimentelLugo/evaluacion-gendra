package com.gendra.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gendra.inventario.dto.ResponseDto;
import com.gendra.inventario.model.TProducto;
import com.gendra.inventario.service.IProductoService;
import com.gendra.inventario.util.ResponseType;


@Controller
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductosController {
	
	@Autowired
	IProductoService productoService;


	@GetMapping()
	public List<TProducto> listar() {
		return productoService.list();
	}
	

	@SuppressWarnings("rawtypes")
	@PostMapping()
	public HttpEntity guardar(@RequestBody(required = true) TProducto producto) {
		try {
			producto = productoService.save(producto);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR.getEstatus(), ResponseType.UI_PROCESS_ERROR.getDescripcion()));
		}
		return ResponseEntity.ok().header("").body(
				new ResponseDto(ResponseType.UI_PROCESS_OK.getEstatus(), ResponseType.UI_PROCESS_OK.getDescripcion(),producto));
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping()
	public HttpEntity modificar(@RequestBody(required = true) TProducto producto) {
		try {
			producto = productoService.update(producto);
		}catch (NotFoundException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getEstatus(), ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getDescripcion()));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR.getEstatus(), ResponseType.UI_PROCESS_ERROR.getDescripcion()));
		}
		return ResponseEntity.ok().header("").body(
				new ResponseDto(ResponseType.UI_PROCESS_OK.getEstatus(), ResponseType.UI_PROCESS_OK.getDescripcion(),producto));
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("{idProducto}")
	public HttpEntity eliminar(@PathVariable("idProducto") long idProducto) {
		try {
			productoService.delete(idProducto);
		}
		catch (EmptyResultDataAccessException erdae) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getEstatus(), ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getDescripcion()));
		}
		catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR.getEstatus(), ResponseType.UI_PROCESS_ERROR.getDescripcion()));
		}
		return ResponseEntity.ok().header("").body(
				new ResponseDto(ResponseType.UI_PROCESS_OK.getEstatus(), ResponseType.UI_PROCESS_OK.getDescripcion()));

	}

}
