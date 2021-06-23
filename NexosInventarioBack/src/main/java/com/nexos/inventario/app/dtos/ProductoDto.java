package com.nexos.inventario.app.dtos;

import java.util.Date;



public class ProductoDto {

	private Integer id;
	private String nombre;
	private Integer cantidad;
	private Date fechaCreacion;
	private UsuarioDto usuarioCreacion;
	private UsuarioDto usuarioModificacion;
	private Date fechaModificacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public UsuarioDto getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(UsuarioDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public UsuarioDto getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(UsuarioDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
