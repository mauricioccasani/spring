package com.storprocedure.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="proveedor.listarTodo", 
					procedureName="PKG_PROVEEDORES.SP_LISTAR_PROVEEDOR",
							resultClasses= Proveedor.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class )
								
						}					
				)
		}
		)

@Entity
@Table(name = "PROVEEDORES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)

public class Proveedor extends GenericoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProveedor")
	@SequenceGenerator(name = "seqProveedor", allocationSize = 1, sequenceName = "SEQ_PROVEEDORE")
	@Column(name = "ID_PROVEEDOR")
	private Integer id;
	@NotEmpty
	private String dni;
	@NotEmpty
	private String nombre="";
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String telefono;

}
