package com.nexos.inventario.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.inventario.app.models.Usuario;
import com.nexos.inventario.app.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository userRepo;
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		return userRepo.findAll();
	}

}
