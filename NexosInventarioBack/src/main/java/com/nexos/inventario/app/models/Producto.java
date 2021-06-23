package com.nexos.inventario.app.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="producto_id_seq", sequenceName="producto_id_seq", allocationSize=1)
	private Integer id;
	private String nombreProducto;
	private Integer cantidadProducto;
	private Date fechaCreacionProducto;
	@JoinColumn(name = "id_usuario_creacion_producto", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Usuario usuarioCreacion;
	@JoinColumn(name = "id_usuario_modificacion_producto", nullable = true)
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Usuario usuarioModificacion;
	private Date fechaModificacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Date getFechaCreacionProducto() {
		return fechaCreacionProducto;
	}

	public void setFechaCreacionProducto(Date fechaCreacionProducto) {
		this.fechaCreacionProducto = fechaCreacionProducto;
	}

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Usuario getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
