package com.storprocedure.java.service;

import java.util.List;

import com.storprocedure.java.entity.Proveedor;

public interface IProveedorService {
	List<Proveedor> findByLike(Proveedor proveedor) throws Exception;
	List<Proveedor> findByNombre(String term)throws Exception;
	public String save(Proveedor t) throws Exception; 
}
