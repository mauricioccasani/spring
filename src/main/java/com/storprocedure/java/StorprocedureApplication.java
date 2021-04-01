package com.storprocedure.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.storprocedure.java.dao.IProductoDao;
import com.storprocedure.java.dto.ProveedorDto;
import com.storprocedure.java.dto.UsuarioDto;

@SpringBootApplication
public class StorprocedureApplication implements CommandLineRunner {
	@Autowired
	private IProductoDao dao;
	
	

	public static void main(String[] args) {
		SpringApplication.run(StorprocedureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProveedorDto> p=this.dao.listarTodo();
	
		for (ProveedorDto proveedor : p) {
			System.out.println(proveedor);
		}
		
		System.out.println("*******************");
		List<UsuarioDto> usuarioDtos=this.dao.findByLike(null, null);
		for (UsuarioDto usuarioDto : usuarioDtos) {
			System.out.println("Usuarios "+usuarioDto);
		}
	}

}
