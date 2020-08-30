package com.storprocedure.java.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storprocedure.java.dao.ProveedorDao;
import com.storprocedure.java.entity.Proveedor;

@Service
public class ProveedorService implements IProveedorService {
	@Autowired
	private ProveedorDao proveedorDao;

	@Override
	public List<Proveedor> findByLike(Proveedor proveedor) throws Exception {
		List<Proveedor> list;
		try {
			String nombre = proveedor.getNombre();
			//nombre = (nombre == null) ? "" : nombre;

			list = this.proveedorDao.findByLike("%" + nombre + "%");
			return list;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<Proveedor> findByNombre(String term) throws Exception {
		try {
			List<Proveedor> list=this.proveedorDao.findByNombre(term);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}

	@Override
	public String save(Proveedor t) throws Exception {
		/*
		String message = null;
		JSONObject jsonObject = new JSONObject();
		try {
			if (t.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}
			this.proveedorDao.save(t);
			jsonObject.put("status", "success");
			jsonObject.put("title", message+" Confirmation");
			jsonObject.put("message", "Address Proveedor "+t.getNombre() +" "+ message + " successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
		*/
		return null;
	}
	
		
}
