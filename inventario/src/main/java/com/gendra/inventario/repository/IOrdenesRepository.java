package com.gendra.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gendra.inventario.model.TOrdene;

public interface IOrdenesRepository extends JpaRepository<TOrdene, Long> {

}
