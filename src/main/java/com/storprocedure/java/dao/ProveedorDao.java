package com.storprocedure.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.storprocedure.java.entity.Proveedor;

@Repository
public interface ProveedorDao extends JpaRepository<Proveedor, Integer> {
	@Query("Select p from Proveedor p where nombre like :nombre AND estado='1'")
	List<Proveedor> findByLike(@Param("nombre") String nombre);
	
	@Query("select p from Proveedor p where p.nombre like %?1% and estado='1' ")
	List<Proveedor> findByNombre(String term);

}
