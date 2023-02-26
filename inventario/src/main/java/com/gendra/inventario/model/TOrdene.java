package com.gendra.inventario.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


/**
 * The persistent class for the t_ordenes database table.
 * 
 */
@Entity
@Table(name="t_ordenes", schema = "gendra")
public class TOrdene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_ORDENES_IDTORDENES_GENERATOR", sequenceName="gendra.t_ordenes_id_t_ordenes_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_ORDENES_IDTORDENES_GENERATOR")
	@Column(name="id_t_ordenes")
	private Long idTOrdenes;

	private LocalDate fecha;

	@Column(name="id_t_clientes")
	private Long idTClientes;

	public TOrdene() {
	}

	public Long getIdTOrdenes() {
		return this.idTOrdenes;
	}

	public void setIdTOrdenes(Long idTOrdenes) {
		this.idTOrdenes = idTOrdenes;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Long getIdTClientes() {
		return idTClientes;
	}

	public void setIdTClientes(Long idTClientes) {
		this.idTClientes = idTClientes;
	}


}