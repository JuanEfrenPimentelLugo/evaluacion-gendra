package com.gendra.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gendra.inventario.model.TCliente;

public interface IClientesRepository extends JpaRepository<TCliente, Long> {

}
