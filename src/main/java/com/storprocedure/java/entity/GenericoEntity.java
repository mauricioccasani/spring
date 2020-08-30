package com.storprocedure.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@MappedSuperclass
public class GenericoEntity  implements Serializable{

	private static final long serialVersionUID = 1L;
	//private String estado;
	@Column(name = "AUD_IDUSUARIO")
	private Integer audIdUsuario;
	@Column(name = "AUD_SESION")
	private String idSession;
	//private String audTipo;
	@Column(name = "AUD_IP")
	private String audIp;
	@Column(name = "AUD_NOMBRE_EQUIPO")
	private String audNombreEquipo;
	//private LocalDate audFecha;

}
