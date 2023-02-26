package com.gendra.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gendra.inventario.model.TOrdenProducto;

public interface IOrdenesProductosRepository extends JpaRepository<TOrdenProducto, Long> {

}
