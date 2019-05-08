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
import br.usjt.ads.futebol.model.entity.Time;

@Repository
public class TimeDAO {
	Connection conn;
	
	@Autowired
	public TimeDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}	
	
	public Time inserirTime(Time time) throws IOException {
		String sql = "INSERT INTO time (nome, emblema, coordenador, foto_equipe) values (?, ?, ?, ?)";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, time.getNome());
			pst.setString(2, time.getEmblema());
			pst.setString(3, time.getCoordenador());
			pst.setString(4, time.getFotoEquipe());
			
			pst.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					time.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return time;
	}
	
	public ArrayList<Time> listarTimes(String chave) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "SELECT t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe "
				+ "FROM time t WHERE upper(t.nome) like ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, "%" + chave.toUpperCase() + "%");
		
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setId(rs.getInt("t.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					time.setCoordenador(rs.getString("t.coordenador"));
					time.setFotoEquipe(rs.getString("t.foto_equipe"));
					
					lista.add(time);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Time> listarTimes() throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "SELECT t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe FROM time t";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
		
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setId(rs.getInt("t.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					time.setCoordenador(rs.getString("t.coordenador"));
					time.setFotoEquipe(rs.getString("t.foto_equipe"));
					
					lista.add(time);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Time> listarTimesCampeonatoExists(Campeonato campeonato) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "select t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe from campeonato_time ct, time t, campeonato c where t.id_time = ct.id_time and c.id_campeonato = ct.id_campeonato and ct.id_campeonato = ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, campeonato.getId());
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setId(rs.getInt("t.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					time.setCoordenador(rs.getString("t.coordenador"));
					time.setFotoEquipe(rs.getString("t.foto_equipe"));
					
					if(partidasTime(time.getId(), campeonato) < campeonato.getQuantidadeRodadas() ) {
						lista.add(time);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Time> listarTimesCampeonatoRodada(Campeonato campeonato, int rodada) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "select t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe from campeonato_time ct, time t, campeonato c where t.id_time = ct.id_time and c.id_campeonato = ct.id_campeonato and ct.id_campeonato = ?";
		boolean teste;	
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, campeonato.getId());
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setId(rs.getInt("t.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					time.setCoordenador(rs.getString("t.coordenador"));
					time.setFotoEquipe(rs.getString("t.foto_equipe"));

					if(!verificarTimeExiste(time.getId(), rodada, campeonato.getId())) {
						lista.add(time);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public boolean verificarTimeExiste(int id, int rodada, int idCampeonato) throws IOException{
		String sql = "select id_time_casa, id_time_visitante, id_campeonato from partida_campeonato where (id_time_casa = ? or id_time_visitante = ?) and rodada = ? and id_campeonato = ?";
		boolean teste = false;
		
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.setInt(2, id);
			pst.setInt(3, rodada);
			pst.setInt(4, idCampeonato);
			
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					teste = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		return teste;
	}
	
	public ArrayList<Time> listarTimesPartidaMandante(Campeonato campeonato, Time time, int rodada) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "SELECT t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe FROM time t, campeonato_time ct where t.id_time = ct.id_time and ct.id_campeonato = ? and not EXISTS(SELECT pc.id_time_visitante from partida_campeonato pc where t.id_time = pc.id_time_visitante and ct.id_campeonato = pc.id_campeonato and pc.id_time_casa = ?)"; 
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, campeonato.getId());
			pst.setInt(2, time.getId());
			try(ResultSet rs = pst.executeQuery();){
			
				Time timeDisponivel;
				while(rs.next()) {
					timeDisponivel = new Time();
					timeDisponivel.setId(rs.getInt("t.id_time"));
					timeDisponivel.setNome(rs.getString("t.nome"));
					timeDisponivel.setEmblema(rs.getString("t.emblema"));
					timeDisponivel.setCoordenador(rs.getString("t.coordenador"));
					timeDisponivel.setFotoEquipe(rs.getString("t.foto_equipe"));
					
					if(time.getId() != timeDisponivel.getId() ) {
						if(!verificarTimeExiste(timeDisponivel.getId(), rodada, campeonato.getId())) {
							lista.add(timeDisponivel);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Time> listarTimesPartidaVisitante(Campeonato campeonato, Time time, int rodada) throws IOException {
		ArrayList<Time> lista = new ArrayList<>();
		String sql = "SELECT t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe FROM time t, campeonato_time ct where t.id_time = ct.id_time and ct.id_campeonato = ? and "
				+ "not EXISTS(SELECT pc.id_time_casa from partida_campeonato pc where t.id_time = pc.id_time_casa and ct.id_campeonato = pc.id_campeonato and pc.id_time_visitante = ?);"; 

								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, campeonato.getId());
			pst.setInt(2, time.getId());
			try(ResultSet rs = pst.executeQuery();){
			
				Time timeDisponivel;
				while(rs.next()) {
					timeDisponivel = new Time();
					timeDisponivel.setId(rs.getInt("t.id_time"));
					timeDisponivel.setNome(rs.getString("t.nome"));
					timeDisponivel.setEmblema(rs.getString("t.emblema"));
					timeDisponivel.setCoordenador(rs.getString("t.coordenador"));
					timeDisponivel.setFotoEquipe(rs.getString("t.foto_equipe"));
					
					if(time.getId() != timeDisponivel.getId() ) {
						if(!verificarTimeExiste(timeDisponivel.getId(), rodada, campeonato.getId())) {
							lista.add(timeDisponivel);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Integer> timeRodadas(Campeonato campeonato, Time time) throws IOException {
		ArrayList<Integer> lista = new ArrayList<>();
		String sql = "select pc.rodada from partida_campeonato pc where (pc.id_time_casa = ? or pc.id_time_visitante = ?) and pc.id_campeonato = ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, time.getId());
			pst.setInt(2, time.getId());
			pst.setInt(3, campeonato.getId());
			try(ResultSet rs = pst.executeQuery();){
			
				int rodada;
				while(rs.next()) {
						rodada = (rs.getInt("pc.rodada"));
						lista.add(rodada);
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public int partidasTime(int id, Campeonato campeonato) throws IOException{
		String sql = "select COUNT(pc.id_time_casa or pc.id_time_visitante) from partida_campeonato pc where (pc.id_time_casa = ? or pc.id_time_visitante = ?) and pc.id_campeonato = ?";
		int quantidade = 0;
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.setInt(2, id);
			pst.setInt(3, campeonato.getId());
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					quantidade = (rs.getInt("COUNT(pc.id_time_casa or pc.id_time_visitante)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return quantidade;
	}
	
	public int partidasMandante(int id, Campeonato campeonato) throws IOException{
		String sql = "select COUNT(pc.id_time_casa) from partida_campeonato pc where pc.id_time_casa = ? and pc.id_campeonato = ?";
		int quantidade = 0;
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.setInt(2, campeonato.getId());
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					quantidade = (rs.getInt("COUNT(pc.id_time_casa)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return quantidade;
	}
	
	public int partidasVisitante(int id, Campeonato campeonato) throws IOException{
		String sql = "select COUNT(pc.id_time_visitante) from partida_campeonato pc where pc.id_time_visitante = ? and pc.id_campeonato = ?";
		int quantidade = 0;
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.setInt(2, campeonato.getId());
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					quantidade = (rs.getInt("COUNT(pc.id_time_visitante)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return quantidade;
	}
	
	public Time buscarTime(int id) throws IOException{
		String sql = "SELECT t.id_time, t.nome, t.emblema, t.coordenador, t.foto_equipe FROM time t WHERE id_time = ?";
		Time time = new Time();
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
				
				if(rs.next()) {
					time.setId(rs.getInt("t.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					time.setCoordenador(rs.getString("t.coordenador"));
					time.setFotoEquipe(rs.getString("t.foto_equipe"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return time;
	}
	
	public Time alterarTime(Time time) throws IOException{
		String sql = "UPDATE time SET nome = ?, emblema = ?, coordenador = ?, foto_equipe = ? WHERE id_time = ?";
		
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			
			stm.setString(1, time.getNome());
			stm.setString(2, time.getEmblema());
			stm.setString(3, time.getCoordenador());
			stm.setString(4, time.getFotoEquipe());
			stm.setInt(5, time.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
	public void excluirTime(int id) throws IOException{
		String sql = "DELETE FROM time WHERE id_time = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.execute();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Time> listarTimesCampeonato(int id) throws IOException{
		String sql = "SELECT t.id_time, t.nome, t.emblema, t.coordenador, foto_equipe FROM time t WHERE not EXISTS (SELECT * FROM campeonato_time tc WHERE t.id_time = tc.id_time and tc.id_campeonato = ? )";
		ArrayList<Time> lista = new ArrayList<>();
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
		
			try(ResultSet rs = pst.executeQuery();){
			
				Time time;
				while(rs.next()) {
					time = new Time();
					time.setId(rs.getInt("t.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					time.setCoordenador(rs.getString("t.coordenador"));
					time.setFotoEquipe(rs.getString("t.foto_equipe"));
					
					lista.add(time);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
}
