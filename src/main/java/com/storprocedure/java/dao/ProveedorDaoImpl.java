package com.storprocedure.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.storprocedure.java.entity.Proveedor;
@Transactional
@Repository("proveedorDaoImpl")
public class ProveedorDaoImpl {

	@Autowired
	//@PersistenceContext
	private EntityManager em;

	//@SuppressWarnings("unchecked")
	public List<Proveedor> getProvedores() {
		List<Proveedor> lstProveedor = new ArrayList<>();
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proveedor.listarTodo");
			lstProveedor=(List<Proveedor>) spq.getOutputParameterValue("P_CURSOR");
			spq.execute();
			//if (spq.execute()) {
			//	lstProveedor = (List<Proveedor>) spq.getOutputParameterValue("P_CURSOR");
			//}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstProveedor;
	}

}
