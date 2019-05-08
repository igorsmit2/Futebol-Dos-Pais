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
import br.usjt.ads.futebol.model.entity.Jogador;
import br.usjt.ads.futebol.model.entity.Partida;
import br.usjt.ads.futebol.model.entity.Posicao;
import br.usjt.ads.futebol.model.entity.Time;

@Repository
public class JogadorDAO {
	Connection conn;
	
	@Autowired
	public JogadorDAO(DataSource data) throws IOException {
		try {
			conn = data.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public Jogador inserirJogador(Jogador jogador) throws IOException {
		String sql = "INSERT INTO jogador (apelido, capitao, foto_jogador, id_posicao, id_categoria, id_time) values (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, jogador.getApelido());
			pst.setBoolean(2, jogador.isCapitao());
			pst.setString(3, jogador.getFotoJogador());
			pst.setInt(4, jogador.getPosicao().getId());
			pst.setInt(5, jogador.getCategoria().getId());
			pst.setInt(6, jogador.getTime().getId());
			
			pst.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					jogador.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return jogador;
	}
	
	public ArrayList<Jogador> listarJogadores(String chave) throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "SELECT j.id_jogador, j.apelido, j.capitao, j.foto_jogador, j.id_posicao, j.id_categoria, j.id_time, t.nome, t.emblema, c.nome, p.nome "
				+ "FROM jogador j, time t, posicao p, categoria c WHERE j.id_time = t.id_time and j.id_posicao = p.id_posicao and j.id_categoria = c.id_categoria and upper(j.apelido) like ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, "%" + chave.toUpperCase() + "%");
		
			try(ResultSet rs = pst.executeQuery();){
			
				Jogador jogador;
				Posicao posicao;
				Categoria categoria;
				Time time;
				while(rs.next()) {
					time = new Time();
					jogador = new Jogador();
					posicao = new Posicao();
					categoria = new Categoria();
					jogador.setId(rs.getInt("j.id_jogador"));
					jogador.setApelido(rs.getString("j.apelido"));
					jogador.setCapitao(rs.getBoolean("j.capitao"));
					jogador.setFotoJogador(rs.getString("j.foto_jogador"));
					posicao.setId(rs.getInt("j.id_posicao"));
					categoria.setId(rs.getInt("j.id_categoria"));
					time.setId(rs.getInt("j.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					categoria.setNome(rs.getString("c.nome"));
					posicao.setNome(rs.getString("p.nome"));
					
					jogador.setCategoria(categoria);
					jogador.setTime(time);
					jogador.setPosicao(posicao);
					
					lista.add(jogador);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Jogador> listarJogadores() throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "SELECT j.id_jogador, j.apelido, j.capitao, j.foto_jogador, j.id_posicao, j.id_categoria, j.id_time, t.nome, t.emblema, c.nome, p.nome "
				+ "FROM jogador j, time t, posicao p, categoria c WHERE j.id_time = t.id_time and j.id_posicao = p.id_posicao and j.id_categoria = c.id_categoria";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
		
			try(ResultSet rs = pst.executeQuery();){
			
				Jogador jogador;
				Posicao posicao;
				Categoria categoria;
				Time time;
				while(rs.next()) {
					time = new Time();
					jogador = new Jogador();
					posicao = new Posicao();
					categoria = new Categoria();
					jogador.setId(rs.getInt("j.id_jogador"));
					jogador.setApelido(rs.getString("j.apelido"));
					jogador.setCapitao(rs.getBoolean("j.capitao"));
					jogador.setFotoJogador(rs.getString("j.foto_jogador"));
					posicao.setId(rs.getInt("j.id_posicao"));
					categoria.setId(rs.getInt("j.id_categoria"));
					time.setId(rs.getInt("j.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					categoria.setNome(rs.getString("c.nome"));
					posicao.setNome(rs.getString("p.nome"));
					
					jogador.setCategoria(categoria);
					jogador.setTime(time);
					jogador.setPosicao(posicao);
					
					lista.add(jogador);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public Jogador buscarJogador(int id) throws IOException {
		Jogador jogador = new Jogador();
		String sql = "SELECT j.id_jogador, j.apelido, j.capitao, j.foto_jogador, j.id_posicao, j.id_categoria, j.id_time, t.nome, t.emblema, c.nome, p.nome "
				+ "FROM jogador j, time t, posicao p, categoria c WHERE j.id_time = t.id_time and j.id_posicao = p.id_posicao and j.id_categoria = c.id_categoria and j.id_jogador = ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
		
			try(ResultSet rs = pst.executeQuery();){
					
				Posicao posicao;
				Categoria categoria;
				Time time;
				if(rs.next()) {
					time = new Time();
					jogador = new Jogador();
					posicao = new Posicao();
					categoria = new Categoria();
					jogador.setId(rs.getInt("j.id_jogador"));
					jogador.setApelido(rs.getString("j.apelido"));
					jogador.setCapitao(rs.getBoolean("j.capitao"));
					jogador.setFotoJogador(rs.getString("j.foto_jogador"));
					posicao.setId(rs.getInt("j.id_posicao"));
					categoria.setId(rs.getInt("j.id_categoria"));
					time.setId(rs.getInt("j.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					categoria.setNome(rs.getString("c.nome"));
					posicao.setNome(rs.getString("p.nome"));
					
					jogador.setCategoria(categoria);
					jogador.setTime(time);
					jogador.setPosicao(posicao);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return jogador;
	}
	
	
	
	public ArrayList<Jogador> buscarJogadorTime(int id) throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "SELECT j.id_jogador, j.apelido, j.capitao, j.foto_jogador, j.id_posicao, j.id_categoria, j.id_time, t.nome, t.emblema, c.nome, p.nome "
				+ "FROM jogador j, time t, posicao p, categoria c WHERE j.id_time = t.id_time and j.id_posicao = p.id_posicao and j.id_categoria = c.id_categoria and j.id_time = ?";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, id);
		
			try(ResultSet rs = pst.executeQuery();){
					
				Jogador jogador;
				Posicao posicao;
				Categoria categoria;
				Time time;
				while(rs.next()) {
					time = new Time();
					jogador = new Jogador();
					posicao = new Posicao();
					categoria = new Categoria();
					jogador.setId(rs.getInt("j.id_jogador"));
					jogador.setApelido(rs.getString("j.apelido"));
					jogador.setCapitao(rs.getBoolean("j.capitao"));
					jogador.setFotoJogador(rs.getString("j.foto_jogador"));
					posicao.setId(rs.getInt("j.id_posicao"));
					categoria.setId(rs.getInt("j.id_categoria"));
					time.setId(rs.getInt("j.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					categoria.setNome(rs.getString("c.nome"));
					posicao.setNome(rs.getString("p.nome"));
					
					jogador.setCategoria(categoria);
					jogador.setTime(time);
					jogador.setPosicao(posicao);
					
					lista.add(jogador);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public ArrayList<Jogador> listarJogadoresPartida(Partida partida) throws IOException {
		ArrayList<Jogador> lista = new ArrayList<>();
		String sql = "SELECT j.id_jogador, j.apelido, j.capitao, j.foto_jogador, j.id_posicao, j.id_categoria, j.id_time, t.nome, t.emblema, c.nome, p.nome "
				+ "FROM jogador j, time t, posicao p, categoria c WHERE j.id_time = t.id_time and j.id_posicao = p.id_posicao and j.id_categoria = c.id_categoria and (j.id_time = ? or j.id_time = ?)";
								
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setInt(1, partida.getTimeMandante().getId());
			pst.setInt(2, partida.getTimeVisitante().getId());
		
			try(ResultSet rs = pst.executeQuery();){
					
				Jogador jogador;
				Posicao posicao;
				Categoria categoria;
				Time time;
				while(rs.next()) {
					time = new Time();
					jogador = new Jogador();
					posicao = new Posicao();
					categoria = new Categoria();
					jogador.setId(rs.getInt("j.id_jogador"));
					jogador.setApelido(rs.getString("j.apelido"));
					jogador.setCapitao(rs.getBoolean("j.capitao"));
					jogador.setFotoJogador(rs.getString("j.foto_jogador"));
					posicao.setId(rs.getInt("j.id_posicao"));
					categoria.setId(rs.getInt("j.id_categoria"));
					time.setId(rs.getInt("j.id_time"));
					time.setNome(rs.getString("t.nome"));
					time.setEmblema(rs.getString("t.emblema"));
					categoria.setNome(rs.getString("c.nome"));
					posicao.setNome(rs.getString("p.nome"));
					
					jogador.setCategoria(categoria);
					jogador.setTime(time);
					jogador.setPosicao(posicao);
					
					lista.add(jogador);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	public Jogador alterarJogador(Jogador jogador) throws IOException{
		String sql = "UPDATE jogador SET apelido = ?, capitao = ?, foto_jogador = ?, id_posicao = ?, id_categoria = ?, id_time = ? WHERE id_jogador = ?";
		
		try (PreparedStatement stm = conn.prepareStatement(sql);) {
			
			stm.setString(1, jogador.getApelido());
			stm.setBoolean(2, jogador.isCapitao());
			stm.setString(3, jogador.getFotoJogador());
			stm.setInt(4, jogador.getPosicao().getId());
			stm.setInt(5, jogador.getCategoria().getId());
			stm.setInt(6, jogador.getTime().getId());
			stm.setInt(7, jogador.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogador;
	}
	
	public void excluirJogador(int id) throws IOException{
		String sql = "DELETE FROM jogador WHERE id_jogador = ?";
		try(PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.execute();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
