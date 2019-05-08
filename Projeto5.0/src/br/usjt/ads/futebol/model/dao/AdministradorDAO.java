package br.usjt.ads.futebol.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.ads.futebol.model.entity.Administrador;

@Repository
public class AdministradorDAO {
	Connection conn;
	
	@Autowired
	public AdministradorDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public boolean autenticarAdministrador(Administrador administrador) throws IOException{
		String sql = "SELECT username, password FROM administrador "
				+ "WHERE username = ? and password = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setString(1, administrador.getUsername());
				stm.setString(2, administrador.getPassword());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
