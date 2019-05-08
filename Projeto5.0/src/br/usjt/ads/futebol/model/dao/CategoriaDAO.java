package br.usjt.ads.futebol.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.ads.futebol.model.entity.Categoria;
@Repository
public class CategoriaDAO {
	Connection conn;
	
	@Autowired
	public CategoriaDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public ArrayList<Categoria> listarCategoria() throws IOException {
		ArrayList<Categoria> lista = new ArrayList<>();
		String sql = "SELECT c.id_categoria, c.nome FROM categoria c";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
		
			try(ResultSet rs = pst.executeQuery();){
			
				Categoria categoria;
				while(rs.next()) {
					categoria = new Categoria();
					categoria.setId(rs.getInt("c.id_categoria"));
					categoria.setNome(rs.getString("c.nome"));
					
					lista.add(categoria);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
}
