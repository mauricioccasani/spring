package com.storprocedure.java.dto;

import javax.persistence.Inheritance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper=false)
@ToString
@Data
@Inheritance
@AllArgsConstructor
@NoArgsConstructor
public class RolDto extends GenericoDto {
	
	private Integer idRol;
	private String nombre;
	private String descripcion;
	public RolDto(Integer idRol) {
		super();
		this.idRol = idRol;
	}

}
