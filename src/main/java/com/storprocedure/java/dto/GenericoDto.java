package com.storprocedure.java.dto;

import java.sql.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
public class GenericoDto {
	private String estado;
	private Integer audIdUsuario;
	private String audSession;
	private String audTipo;
	private String audIp;
	private String audNombreEquipo;
	private Date audFecha;
	
}
