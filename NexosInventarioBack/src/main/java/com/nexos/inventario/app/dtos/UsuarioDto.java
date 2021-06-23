package com.nexos.inventario.app.dtos;

import java.util.Date;

public class UsuarioDto {
	private Integer id;
	private String nombre;
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private CargoDto cargo;
    
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
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public CargoDto getCargo() {
		return cargo;
	}
	public void setCargo(CargoDto cargo) {
		this.cargo = cargo;
	}
    
	
}
