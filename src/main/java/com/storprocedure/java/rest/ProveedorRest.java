package com.storprocedure.java.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storprocedure.java.dao.ProveedorDao;
import com.storprocedure.java.dao.ProveedorDaoImpl;
import com.storprocedure.java.entity.Proveedor;

@RestController
@RequestMapping("proveedor")
public class ProveedorRest {

	@Autowired
	private ProveedorDao proveedorDao;
	
	@Autowired
	private ProveedorDaoImpl roveedorDaoImpl;
	@GetMapping("/listado")
	public List<Proveedor> listarPro(){
		return this.proveedorDao.findAll();
	}

	@PostMapping("/save")
	public String save(@RequestBody Proveedor proveedor){
		Proveedor proveedor2= this.proveedorDao.save(proveedor);
		//String.valueOf(proveedor2.getId());
		return proveedor2.toString();
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listar() {
		System.out.println("eeeeeee");
		List<Proveedor> list = null;
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			list = this.proveedorDao.findAll();

			response.put("proveedor", list);
		} catch (DataAccessException ex) {
			response.put("mensaje", "Error al realizar al realizar consulta en la BD");
			response.put("error", ex.getMessage().concat(" ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		response.put("mensaje", "exito al listar");
		response.put("codigo", "1");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarProveedor() {
		List<Proveedor> list =new  ArrayList<>();
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			list = this.roveedorDaoImpl.getProvedores();

			response.put("proveedor", list);
		} catch (DataAccessException ex) {
			response.put("mensaje", "Error al realizar al realizar consulta en la BD");
			response.put("error", ex.getMessage().concat(" ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "exito al listar");
		response.put("codigo", "1");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
