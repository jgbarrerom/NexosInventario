package com.nexos.inventario.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.inventario.app.controllers.constants.URIConstants;
import com.nexos.inventario.app.dtos.ProductoDto;
import com.nexos.inventario.app.models.Producto;
import com.nexos.inventario.app.services.ProductoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inventario")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
    private ModelMapper modelMapper;

	@GetMapping(value = URIConstants.GET_PRODUCT_LIST)
	public List<ProductoDto> getListProductos(){
		return productoService.obtenerProductos().stream().map(producto -> modelMapper.map(producto, ProductoDto.class))
				.collect(Collectors.toList());
	}
	
	@PostMapping(value = URIConstants.POST_PRODUCT)
	public ProductoDto crearProducto(@RequestBody ProductoDto producto){
		Producto prod = modelMapper.map(producto, Producto.class);
		return modelMapper.map(productoService.crearProducto(prod), ProductoDto.class);
	}
	
	@PutMapping(value = URIConstants.PUT_PRODUCT)
	public ProductoDto actualizarProducto(@RequestBody ProductoDto producto){
		return modelMapper.map(productoService.modificarProducto(modelMapper.map(producto, Producto.class)), ProductoDto.class);
	}
	
	
	@DeleteMapping(value = URIConstants.DELETE_PRODUCT)
	public void eliminarProducto(@RequestBody ProductoDto producto){
		productoService.eliminarProducto(modelMapper.map(producto, Producto.class));
	}
	
}
