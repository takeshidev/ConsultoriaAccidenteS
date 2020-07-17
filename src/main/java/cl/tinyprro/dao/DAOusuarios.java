package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Usuario;

public class DAOusuarios {

	// SQL QUERYS
	private final String SQL_LISTAR_TODO = 
			"SELECT IDUSUARIO ,USUARIO , TIPOUSUARIO , CLAVE , MAIL , ACTIVO  from usuario order by idusuario asc";
	
	JdbcTemplate template;
		
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/**
	 * M�todo buscar todas las actividades
	 * @return Lista de actividades
	 */
	public List<Usuario> buscarTodos(){
		
		return template.query(SQL_LISTAR_TODO, new UsuarioMapper());
	}
	
	public class UsuarioMapper implements RowMapper<Usuario>{
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Usuario(
					rs.getInt("IDUSUARIO"),
					rs.getString("USUARIO"),
					rs.getString("TIPOUSUARIO"),
					rs.getString("CLAVE"),
					rs.getString("MAIL"),
					rs.getString("ACTIVO")
					);
					
		};
	}
	
	
}
