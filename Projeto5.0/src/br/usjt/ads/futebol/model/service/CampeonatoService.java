package br.usjt.ads.futebol.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.CampeonatoDAO;
import br.usjt.ads.futebol.model.entity.Campeonato;
import br.usjt.ads.futebol.model.entity.Partida;
import br.usjt.ads.futebol.model.entity.Time;

@Service
public class CampeonatoService {
	@Autowired
	private CampeonatoDAO dao;
	
	@Transactional
	public Campeonato inserirCampeonato(Campeonato campeonato) throws IOException{
		return dao.inserirCampeonato(campeonato);
	}
	
	public int timesCampeonato(int id) throws IOException{
		return dao.timesCampeonato(id);
	}
	
	public Campeonato buscarCampeonato(int id) throws IOException{
		return dao.buscarCampeonato(id);
	}
	
	@Transactional
	public void inserirTimeCampeonato(int id,Time time) throws IOException{
		dao.inserirTimeCampeonato(id, time);
	}
	
	public ArrayList<Campeonato> listarCampeonato(String chave) throws IOException{
		return dao.listarCampeonatos(chave);
	}
	
	public void inserirPartida(Partida partida, int rodada) throws IOException{
		dao.inserirPartida(partida, rodada);
	}
	
	public ArrayList<Partida> listarPartidas(int id) throws IOException {
		return dao.listarPartidas(id);
	}
	
	public int quantidadeRodadas(int rodada, int idCampeonato) throws IOException{
		return dao.quantidadeRodadas(rodada, idCampeonato);
	}
	
	public ArrayList<Partida> listarPartidas(Partida partida, int id) throws IOException {
		return dao.listarPartidas(partida, id);
	}
	public void atualizarStatus(Partida partida) throws IOException{
		dao.atualizarStatus(partida);
	}
}
