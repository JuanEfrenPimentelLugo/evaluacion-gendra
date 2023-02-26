package com.gendra.inventario.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the t_productos database table.
 * 
 */
@Entity
@Table(name="t_productos", schema = "gendra")
public class TProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_PRODUCTOS_IDTPRODUCTOS_GENERATOR", sequenceName="gendra.t_productos_id_t_productos_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_PRODUCTOS_IDTPRODUCTOS_GENERATOR")
	@Column(name="id_t_productos")
	private Long idTProductos;

	private String nombre;

	private BigDecimal precio;

	public TProducto() {
	}

	public Long getIdTProductos() {
		return this.idTProductos;
	}

	public void setIdTProductos(Long idTProductos) {
		this.idTProductos = idTProductos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


}