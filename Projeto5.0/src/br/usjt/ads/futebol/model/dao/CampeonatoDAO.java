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
import br.usjt.ads.futebol.model.entity.Partida;
import br.usjt.ads.futebol.model.entity.Time;

@Repository
public class CampeonatoDAO {
	Connection conn;
	
	@Autowired
	public CampeonatoDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}	
	public void inserirTimeCampeonato(int id, Time time) throws IOException{
		String sql = "INSERT INTO campeonato_time (id_time, id_campeonato) values (?, ?)";
		
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, time.getId());
			pst.setInt(2, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public void inserirPartida(Partida partida, int rodada) throws IOException{
		String sql = "insert into partida_campeonato(id_campeonato, id_time_casa, id_time_visitante, rodada, data_partida) values (?, ?, ?, ?, ?);";
		
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, partida.getCampeonato().getId());
			pst.setInt(2, partida.getTimeMandante().getId());
			pst.setInt(3, partida.getTimeVisitante().getId());
			pst.setInt(4, rodada);
			pst.setDate(5, new java.sql.Date(partida.getDataPartida().getTime()));
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public Campeonato inserirCampeonato(Campeonato campeonato) throws IOException {
		String sql = "INSERT INTO campeonato (nome, quantidade_turno, quantidade_times, quantidade_rodadas, pontos_vitoria, pontos_empate, pontos_derrota) values (?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, campeonato.getNome());
			pst.setInt(2, campeonato.getQuantidadeTurno());
			pst.setInt(3, campeonato.getQuantidadeTimes());
			if(campeonato.getQuantidadeTurno() == 2) {
				int rodadas = (campeonato.getQuantidadeTimes() - 1) * campeonato.getQuantidadeTurno();
				pst.setInt(4, rodadas);
			} else {
				pst.setInt(4, (campeonato.getQuantidadeTimes() - 1));
			}
			pst.setInt(5, campeonato.getPontosVitoria());
			pst.setInt(6, campeonato.getPontosEmpate());
			pst.setInt(7, campeonato.getPontosDerrota());
			pst.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					campeonato.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return campeonato;
	}
	
	public int timesCampeonato(int id) throws IOException{
		String sql = "select COUNT(c.id_campeonato) from campeonato_time c where c.id_campeonato = ?";
		int quantidade = 0;
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					quantidade = (rs.getInt("COUNT(c.id_campeonato)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return quantidade;
	}
	
	public Campeonato buscarCampeonato(int id) throws IOException{
		String sql = "SELECT c.id_campeonato, c.nome, c.quantidade_turno, c.quantidade_times, c.quantidade_rodadas, c.pontos_vitoria, c.pontos_empate, c.pontos_derrota FROM campeonato c WHERE id_campeonato = ?";
		Campeonato campeonato = new Campeonato();
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					campeonato.setId(rs.getInt("c.id_campeonato"));
					campeonato.setNome(rs.getString("c.nome"));
					campeonato.setQuantidadeTurno(rs.getInt("c.quantidade_turno"));
					campeonato.setQuantidadeTimes(rs.getInt("c.quantidade_times"));
					campeonato.setQuantidadeRodadas(rs.getInt("c.quantidade_rodadas"));
					campeonato.setPontosVitoria(rs.getInt("c.pontos_vitoria"));
					campeonato.setPontosEmpate(rs.getInt("c.pontos_empate"));
					campeonato.setPontosDerrota(rs.getInt("c.pontos_derrota"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return campeonato;
	}
	
	public Campeonato buscarTabela(int id) throws IOException{
		String sql = "SELECT c.id_campeonato, c.nome, c.quantidade_turno, c.quantidade_times, c.quantidade_rodadas, c.pontos_vitoria, c.pontos_empate, c.pontos_derrota FROM campeonato c WHERE id_campeonato = ?";
		Campeonato campeonato = new Campeonato();
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					campeonato.setId(rs.getInt("c.id_campeonato"));
					campeonato.setNome(rs.getString("c.nome"));
					campeonato.setQuantidadeTurno(rs.getInt("c.quantidade_turno"));
					campeonato.setQuantidadeTimes(rs.getInt("c.quantidade_times"));
					campeonato.setQuantidadeRodadas(rs.getInt("c.quantidade_rodadas"));
					campeonato.setPontosVitoria(rs.getInt("c.pontos_vitoria"));
					campeonato.setPontosEmpate(rs.getInt("c.pontos_empate"));
					campeonato.setPontosDerrota(rs.getInt("c.pontos_derrota"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return campeonato;
	}
	
	public ArrayList<Campeonato> listarCampeonatos(String chave) throws IOException {
		ArrayList<Campeonato> lista = new ArrayList<>();
		String sql = "SELECT c.id_campeonato, c.nome, c.quantidade_turno, c.quantidade_times, c.quantidade_rodadas, c.pontos_vitoria, c.pontos_empate, c.pontos_derrota FROM campeonato c WHERE upper(c.nome) like ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, "%" + chave.toUpperCase() + "%");
		
			try(ResultSet rs = pst.executeQuery();){
			
				Campeonato campeonato;
				while(rs.next()) {
					campeonato = new Campeonato();
					campeonato.setId(rs.getInt("c.id_campeonato"));
					campeonato.setNome(rs.getString("c.nome"));
					campeonato.setQuantidadeTurno(rs.getInt("c.quantidade_turno"));
					campeonato.setQuantidadeRodadas(rs.getInt("c.quantidade_rodadas"));
					campeonato.setPontosVitoria(rs.getInt("c.pontos_vitoria"));
					campeonato.setPontosEmpate(rs.getInt("c.pontos_empate"));
					campeonato.setPontosDerrota(rs.getInt("c.pontos_derrota"));
					
					lista.add(campeonato);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Partida> listarPartidas(int id) throws IOException {
		ArrayList<Partida> lista = new ArrayList<>();
		String sql = "select id_campeonato, id_time_casa, id_time_visitante, rodada, data_partida from partida_campeonato where id_campeonato = ? order by rodada asc";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
			
				Partida partida;
				Time timeMandante, timeVisitante;
				Campeonato campeonato;
				while(rs.next()) {
					campeonato = new Campeonato();
					timeMandante = new Time();
					timeVisitante = new Time();
					partida = new Partida();
					campeonato.setId(rs.getInt("id_campeonato"));
					timeMandante.setId(rs.getInt("id_time_casa"));
					timeVisitante.setId(rs.getInt("id_time_visitante"));
					partida.setRodada(rs.getInt("rodada"));
					partida.setDataPartida(rs.getDate("data_partida"));
					
					partida.setTimeMandante(timeMandante);
					partida.setTimeVisitante(timeVisitante);
					partida.setCampeonato(campeonato);
					
					lista.add(partida);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Partida> listarPartidas(Partida partida, int id) throws IOException {
		ArrayList<Partida> lista = new ArrayList<>();
		String sql = "select id_campeonato, id_time_casa, id_time_visitante, rodada, data_partida from partida_campeonato where id_campeonato = ? and (id_time_casa = ? or id_time_visitante = ?)";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, partida.getCampeonato().getId());
			pst.setInt(2, id);
			pst.setInt(3, id);
			try(ResultSet rs = pst.executeQuery();){
			
				Partida partidas;
				Time timeMandante, timeVisitante;
				Campeonato campeonato;
				while(rs.next()) {
					campeonato = new Campeonato();
					timeMandante = new Time();
					timeVisitante = new Time();
					partidas = new Partida();
					campeonato.setId(rs.getInt("id_campeonato"));
					timeMandante.setId(rs.getInt("id_time_casa"));
					timeVisitante.setId(rs.getInt("id_time_visitante"));
					partidas.setRodada(rs.getInt("rodada"));
					partidas.setDataPartida(rs.getDate("data_partida"));
					
					partidas.setTimeMandante(timeMandante);
					partidas.setTimeVisitante(timeVisitante);
					partidas.setCampeonato(campeonato);
					
					lista.add(partidas);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public void atualizarStatus(Partida partida) throws IOException{
		String sql = "UPDATE partida_campeonato SET status = true WHERE id_time_casa = ? and id_time_visitante = ? and id_campeonato = ?";
		
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			
			stm.setBoolean(1, true);
			stm.setInt(2, partida.getTimeMandante().getId());
			stm.setInt(3, partida.getTimeVisitante().getId());
			stm.setInt(4, partida.getCampeonato().getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int quantidadeRodadas(int rodada, int idCampeonato) throws IOException{
		String sql = "select COUNT(rodada) from partida_campeonato where rodada = ? and id_campeonato = ?";
		int rodadas = 0;
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, rodada);
			pst.setInt(2, idCampeonato);
			
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					rodadas = (rs.getInt("COUNT(rodada)"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return rodadas;
	}
	
	
}
