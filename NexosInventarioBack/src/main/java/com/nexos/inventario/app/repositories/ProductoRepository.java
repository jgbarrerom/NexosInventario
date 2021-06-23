package com.nexos.inventario.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexos.inventario.app.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
