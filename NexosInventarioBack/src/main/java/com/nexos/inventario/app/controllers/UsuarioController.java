package com.nexos.inventario.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.inventario.app.controllers.constants.URIConstants;
import com.nexos.inventario.app.dtos.UsuarioDto;
import com.nexos.inventario.app.services.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inventario")
public class UsuarioController {

	@Autowired
	private UsuarioService userServ;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping(value = URIConstants.GET_USER_LIST, method = RequestMethod.GET)
	public List<UsuarioDto> getAllUsuarios(){
		return userServ.obtenerUsuarios().stream().map(user -> modelMapper.map(user, UsuarioDto.class)).collect(Collectors.toList());
	}
}
