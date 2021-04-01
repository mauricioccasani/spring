package com.storprocedure.java.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.storprocedure.java.dto.ProveedorDto;
import com.storprocedure.java.dto.RolDto;
import com.storprocedure.java.dto.UsuarioDto;

import oracle.jdbc.OracleTypes;

@Repository
public class ProveedorDaoImpl implements IProductoDao {
	@Autowired
	private DataSource ds;

	@Override
	public List<ProveedorDto> listarTodo() {
		String sql = "{ CALL PKG_PROVEEDORES.SP_LISTAR_PROVEEDOR(?) }";
		List<ProveedorDto> proveedors = new ArrayList<ProveedorDto>();
		ResultSet rs = null;
		CallableStatement cs=null;
		Connection cn=null;
		try {
			cn = ds.getConnection();
			cs = cn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				ProveedorDto p = new ProveedorDto();
				p.setId(rs.getInt("ID_PROVEEDOR"));
				p.setDni(rs.getString("DNI"));
				p.setNombre(rs.getString("NOMBRE"));
				p.setDireccion(rs.getString("DIRECCION"));
				p.setTelefono(rs.getString("TELEFONO"));

				proveedors.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cs != null)
					cs.close();
				if (cn != null)
					cn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return proveedors;
	}

	@Override
	public List<UsuarioDto> findByLike(String usu, String nombres) {
		List<UsuarioDto> lista = new ArrayList<UsuarioDto>();
		CallableStatement cs = null;
		Connection conn = null;
		String sql = "{ CALL PKG_USUARIO.SP_LISTAR(?,?,?) }";
		ResultSet rs = null;
		try {
			// log.info(sql);
			conn = this.ds.getConnection();
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setString(2, usu);
			cs.setString(3, nombres);
			cs.execute();
			rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				UsuarioDto usuarioDto = new UsuarioDto();
				RolDto rolDto = new RolDto();
				usuarioDto.setIdUsuario(rs.getInt("ID_USUARIO"));
				usuarioDto.setUsuario(rs.getString("USUARIO"));
				usuarioDto.setNombres(rs.getString("NOMBRES"));
				usuarioDto.setApellidos(rs.getString("APELLIDOS"));
				usuarioDto.setNumeroDcumento(rs.getString("NUMERO_DOCUMENTO"));
				usuarioDto.setEmail(rs.getString("EMAIL"));
				usuarioDto.setClave(rs.getString("CLAVE"));
				rolDto.setIdRol(rs.getInt("ID_ROL"));
				usuarioDto.setRolDto(rolDto);
				usuarioDto.setEstado(rs.getString("ESTADO"));
				usuarioDto.setAudIdUsuario(rs.getInt("AUD_IDUSUARIO"));
				usuarioDto.setAudSession(rs.getString("AUD_SESION"));
				usuarioDto.setAudTipo(rs.getString("AUD_TIPO"));
				usuarioDto.setAudIp(rs.getString("AUD_IP"));
				usuarioDto.setAudNombreEquipo(rs.getString("AUD_NOMBRE_EQUIPO"));
				usuarioDto.setAudFecha(rs.getDate("AUD_FECHA"));
				lista.add(usuarioDto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cs != null)
					cs.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return lista;
	}

}
