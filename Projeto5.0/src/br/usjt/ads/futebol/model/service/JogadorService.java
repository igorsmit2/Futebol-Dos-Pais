package br.usjt.ads.futebol.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.JogadorDAO;
import br.usjt.ads.futebol.model.entity.Jogador;
import br.usjt.ads.futebol.model.entity.Partida;

@Service
public class JogadorService {
	@Autowired
	private JogadorDAO dao;
	
	@Transactional
	public Jogador inserirJogador(Jogador jogador) throws IOException{
		return dao.inserirJogador(jogador);
	}
	
	public ArrayList<Jogador> listarJogador(String chave) throws IOException{
		return dao.listarJogadores(chave);
	}
	
	public ArrayList<Jogador> listarJogador() throws IOException{
		return dao.listarJogadores();
	}
	
	public Jogador buscarJogador(int id) throws IOException{
		return dao.buscarJogador(id);
	}
	
	@Transactional
	public void excluirJogador(int id) throws IOException{
		dao.excluirJogador(id);
	}
	
	@Transactional
	public Jogador alterarJogador(Jogador jogador) throws IOException{
		return dao.alterarJogador(jogador);
	}
	
	public ArrayList<Jogador> buscarJogadorTime(int id) throws IOException{
		return dao.buscarJogadorTime(id);
	}
	
	public ArrayList<Jogador> listarJogadoresPartida(Partida partida) throws IOException {
		return dao.listarJogadoresPartida(partida);
	}
}
