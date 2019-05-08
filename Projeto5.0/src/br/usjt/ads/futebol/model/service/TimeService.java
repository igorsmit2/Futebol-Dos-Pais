package br.usjt.ads.futebol.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.TimeDAO;
import br.usjt.ads.futebol.model.entity.Campeonato;
import br.usjt.ads.futebol.model.entity.Time;

@Service
public class TimeService {
	@Autowired
	private TimeDAO dao;
	
	@Transactional
	public Time inserirTime(Time time) throws IOException{
		return dao.inserirTime(time);
	}
	
	public ArrayList<Time> listarTimes(String chave) throws IOException{
		return dao.listarTimes(chave);
	}
	
	public ArrayList<Time> listarTimes() throws IOException{
		return dao.listarTimes();
	}
	
	public Time buscarTime(int id) throws IOException{
		return dao.buscarTime(id);
	}
	
	@Transactional
	public Time alterarTime(Time time) throws IOException{
		return dao.alterarTime(time);
	}
	
	@Transactional
	public void excluirTime(int id) throws IOException{
		dao.excluirTime(id);
	}
	
	public ArrayList<Time> listarTimeCampeonato(int id) throws IOException{
		return dao.listarTimesCampeonato(id);
	}
	
	public ArrayList<Time> listarTimesCampeonatoExists(Campeonato campeonato) throws IOException {
		return dao.listarTimesCampeonatoExists(campeonato);
	}
	
	public ArrayList<Integer> timeRodadas(Campeonato campeonato, Time time) throws IOException {
		return dao.timeRodadas(campeonato, time);
	}
	
	public int partidasVisitante(int id, Campeonato campeonato) throws IOException{
		return dao.partidasVisitante(id, campeonato);
	}
	
	public int partidasMandante(int id, Campeonato campeonato) throws IOException{
		return dao.partidasMandante(id, campeonato);
	}
	
	public ArrayList<Time> listarTimesPartidaVisitante(Campeonato campeonato, Time time, int rodada) throws IOException {
		return dao.listarTimesPartidaVisitante(campeonato, time, rodada);
	}
	
	public ArrayList<Time> listarTimesPartidaMandante(Campeonato campeonato, Time time, int rodada) throws IOException {
		return dao.listarTimesPartidaMandante(campeonato, time, rodada);
	}
	
	public ArrayList<Time> listarTimesCampeonatoRodada(Campeonato campeonato, int rodada) throws IOException {
		return dao.listarTimesCampeonatoRodada(campeonato, rodada);
	}
	
}
