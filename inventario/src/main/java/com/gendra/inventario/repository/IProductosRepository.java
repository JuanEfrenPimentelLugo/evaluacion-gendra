package com.gendra.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gendra.inventario.model.TProducto;

public interface IProductosRepository extends JpaRepository<TProducto, Long> {

}
