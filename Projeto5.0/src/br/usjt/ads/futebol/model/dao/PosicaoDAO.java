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

import br.usjt.ads.futebol.model.entity.Posicao;
@Repository
public class PosicaoDAO {
	Connection conn;
	
	@Autowired
	public PosicaoDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public ArrayList<Posicao> listarPosicao() throws IOException {
		ArrayList<Posicao> lista = new ArrayList<>();
		String sql = "SELECT p.id_posicao, p.nome FROM posicao p";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
		
			try(ResultSet rs = pst.executeQuery();){
			
				Posicao posicao;
				while(rs.next()) {
					posicao = new Posicao();
					posicao.setId(rs.getInt("p.id_posicao"));
					posicao.setNome(rs.getString("p.nome"));
					
					lista.add(posicao);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
}
