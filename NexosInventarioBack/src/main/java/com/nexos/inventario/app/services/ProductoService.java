package com.nexos.inventario.app.services;

import java.util.List;

import com.nexos.inventario.app.models.Producto;

public interface ProductoService {

	Producto crearProducto(Producto producto);

	Producto modificarProducto(Producto producto);

	void eliminarProducto(Producto producto);

	List<Producto> obtenerProductos();
}
