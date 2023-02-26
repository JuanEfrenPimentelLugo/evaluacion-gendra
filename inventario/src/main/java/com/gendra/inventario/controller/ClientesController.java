package com.gendra.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.gendra.inventario.model.TCliente;
import com.gendra.inventario.service.IClienteService;
import com.gendra.inventario.util.ResponseType;

@Controller
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {
	

	@Autowired
	IClienteService clienteService;


	@GetMapping()
	public List<TCliente> listar() {
		return clienteService.list();
	}
	

	@SuppressWarnings("rawtypes")
	@PostMapping()
	public HttpEntity guardar(@RequestBody(required = true) TCliente cliente) {
		try {
			cliente = clienteService.save(cliente);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR.getEstatus(), ResponseType.UI_PROCESS_ERROR.getDescripcion()));
		}
		return ResponseEntity.ok().header("").body(
				new ResponseDto(ResponseType.UI_PROCESS_OK.getEstatus(), ResponseType.UI_PROCESS_OK.getDescripcion(),cliente));
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping()
	public HttpEntity modificar(@RequestBody(required = true) TCliente cliente) {
		try {
			cliente = clienteService.update(cliente);
		}catch (NotFoundException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getEstatus(), ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getDescripcion()));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR.getEstatus(), ResponseType.UI_PROCESS_ERROR.getDescripcion()));
		}
		return ResponseEntity.ok().header("").body(
				new ResponseDto(ResponseType.UI_PROCESS_OK.getEstatus(), ResponseType.UI_PROCESS_OK.getDescripcion(),cliente));
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("{idCliente}")
	public HttpEntity eliminar(@PathVariable("idCliente") long idCliente) {
		try {
			clienteService.delete(idCliente);
		}
		catch (EmptyResultDataAccessException erdae) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getEstatus(), ResponseType.UI_PROCESS_ERROR_NOT_FOUND.getDescripcion()));
		}
		catch (DataIntegrityViolationException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR_FK.getEstatus(), ResponseType.UI_PROCESS_ERROR_FK.getDescripcion()));
		}
		catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).header("").body(new ResponseDto(
					ResponseType.UI_PROCESS_ERROR.getEstatus(), ResponseType.UI_PROCESS_ERROR.getDescripcion()));
		}
		return ResponseEntity.ok().header("").body(
				new ResponseDto(ResponseType.UI_PROCESS_OK.getEstatus(), ResponseType.UI_PROCESS_OK.getDescripcion()));

	}


}
