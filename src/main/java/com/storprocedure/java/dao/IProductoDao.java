package com.storprocedure.java.dao;

import java.util.List;

import com.storprocedure.java.dto.ProveedorDto;
import com.storprocedure.java.dto.UsuarioDto;

public interface IProductoDao {
	
	public List<ProveedorDto>listarTodo();
	public List<UsuarioDto> findByLike(String usu,  String nombres) ;
}
