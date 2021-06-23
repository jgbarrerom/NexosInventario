package com.nexos.inventario.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.inventario.app.models.Producto;
import com.nexos.inventario.app.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepo;

	@Override
	public Producto crearProducto(Producto producto) {
		return this.productoRepo.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return this.crearProducto(producto);
	}

	@Override
	public void eliminarProducto(Producto producto) {
		this.productoRepo.delete(producto);
	}

	@Override
	public List<Producto> obtenerProductos() {
		return this.productoRepo.findAll();
	}
	
	

}
