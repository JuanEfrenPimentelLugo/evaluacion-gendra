package com.gendra.inventario.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_clientes database table.
 * 
 */
@Entity
@Table(name="t_clientes", schema = "gendra")
public class TCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_CLIENTES_IDTCLIENTES_GENERATOR", sequenceName="gendra.t_clientes_id_t_clientes_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_CLIENTES_IDTCLIENTES_GENERATOR")
	@Column(name="id_t_clientes")
	private Long idTClientes;

	@Column(name="apellido_m")
	private String apellidoM;

	@Column(name="apellido_p")
	private String apellidoP;

	private String correo;

	private String nombre;

	private String telefono;

	public TCliente() {
	}

	public Long getIdTClientes() {
		return this.idTClientes;
	}

	public void setIdTClientes(Long idTClientes) {
		this.idTClientes = idTClientes;
	}

	public String getApellidoM() {
		return this.apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getApellidoP() {
		return this.apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}