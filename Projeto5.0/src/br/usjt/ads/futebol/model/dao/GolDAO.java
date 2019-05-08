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

import br.usjt.ads.futebol.model.entity.Campeonato;
import br.usjt.ads.futebol.model.entity.Gol;
import br.usjt.ads.futebol.model.entity.Jogador;
import br.usjt.ads.futebol.model.entity.Partida;
import br.usjt.ads.futebol.model.entity.Time;

@Repository
public class GolDAO {
	Connection conn;
	
	@Autowired
	public GolDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public void inserirGol(Gol gol) throws IOException{
		String sql = "INSERT INTO gol_partida(id_campeonato, id_time_casa, id_time_visitante, gol_time_casa, gol_time_visitante, jogador_id_jogador) values (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, gol.getCampeonato().getId());
			pst.setInt(2, gol.getTimeMandante().getId());
			pst.setInt(3, gol.getTimeVisitante().getId());
			pst.setBoolean(4, gol.isTimeMandanteGol());
			pst.setBoolean(5, gol.isTimeVisitanteGol());
			pst.setInt(6, gol.getJogador().getId());
			
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public ArrayList<Gol> listargols(Gol gol) throws IOException {
		ArrayList<Gol> lista = new ArrayList<>();
		String sql = "select partida_campeonato_id_campeonato, partida_campeonato_id_time_casa, partida_campeonato_id_time_visitante, gol_time_casa, gol_time_visitante, jogador_id_jogador from partida_campeonato where id_campeonato = ? and (id_time_casa = ? or id_time_visitante = ?) and status = ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, gol.getCampeonato().getId());
			pst.setInt(2, gol.getTimeMandante().getId());
			pst.setInt(3, gol.getTimeVisitante().getId());
			pst.setBoolean(4, true);
			try(ResultSet rs = pst.executeQuery();){
			
				Gol gols;
				Time timeMandante, timeVisitante;
				Jogador jogador;
				Campeonato campeonato;
				while(rs.next()) {
					campeonato = new Campeonato();
					timeMandante = new Time();
					timeVisitante = new Time();
					jogador = new Jogador();
					gols = new Gol();
					campeonato.setId(rs.getInt("id_campeonato"));
					timeMandante.setId(rs.getInt("id_time_casa"));
					timeVisitante.setId(rs.getInt("id_time_visitante"));
					gols.setTimeMandanteGol(rs.getBoolean("gol_time_casa"));
					gols.setTimeVisitanteGol(rs.getBoolean("gol_time_visitante"));
					jogador.setId(rs.getInt("jogador_id_jogador"));
					
					gols.setTimeMandante(timeMandante);
					gols.setTimeVisitante(timeVisitante);
					gols.setCampeonato(campeonato);
					
					lista.add(gols);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}

}
