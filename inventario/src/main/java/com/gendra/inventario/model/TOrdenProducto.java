package com.gendra.inventario.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_orden_productos database table.
 * 
 */
@Entity
@Table(name="t_orden_productos", schema = "gendra")
public class TOrdenProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_ORDEN_PRODUCTOS_IDTORDENPRODUCTOS_GENERATOR", sequenceName="gendra.t_orden_productos_id_t_orden_productos_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_ORDEN_PRODUCTOS_IDTORDENPRODUCTOS_GENERATOR")
	@Column(name="id_t_orden_productos")
	private Long idTOrdenProductos;

	private Integer cantidad;
	
	@Column(name="id_t_ordenes")
	private Long idTOrdenes;

	@Column(name="id_t_productos")
	private Long idTProductos;

	//bi-directional many-to-one association to TOrdene
	@ManyToOne
	@JoinColumn(name="id_t_ordenes",insertable = false, updatable = false)
	private TOrdene TOrdene;

	//bi-directional many-to-one association to TProducto
	@ManyToOne
	@JoinColumn(name="id_t_productos",insertable = false, updatable = false)
	private TProducto TProducto;

	public TOrdenProducto() {
	}

	public Long getIdTOrdenProductos() {
		return this.idTOrdenProductos;
	}

	public void setIdTOrdenProductos(Long idTOrdenProductos) {
		this.idTOrdenProductos = idTOrdenProductos;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public TOrdene getTOrdene() {
		return this.TOrdene;
	}

	public void setTOrdene(TOrdene TOrdene) {
		this.TOrdene = TOrdene;
	}

	public TProducto getTProducto() {
		return this.TProducto;
	}

	public void setTProducto(TProducto TProducto) {
		this.TProducto = TProducto;
	}
	
	public Long getIdTOrdenes() {
		return idTOrdenes;
	}

	public void setIdTOrdenes(Long idTOrdenes) {
		this.idTOrdenes = idTOrdenes;
	}

	public Long getIdTProductos() {
		return idTProductos;
	}

	public void setIdTProductos(Long idTProductos) {
		this.idTProductos = idTProductos;
	}

}