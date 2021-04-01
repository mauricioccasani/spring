package com.storprocedure.java.dto;

import javax.persistence.Inheritance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)

@Data
@ToString(callSuper = true)
@Inheritance
public class UsuarioDto extends GenericoDto {
	private Integer idUsuario;
	private String usuario;
	private String nombres;
	private String apellidos;
	private String numeroDcumento;
	private String email;
	private String clave;
	private RolDto rolDto;

}
