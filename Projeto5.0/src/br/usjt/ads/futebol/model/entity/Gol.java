package br.usjt.ads.futebol.model.entity;

public class Gol {
	private Campeonato campeonato;
	private Time timeMandante, timeVisitante;
	private boolean timeMandanteGol, timeVisitanteGol;
	private Jogador jogador;
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public Time getTimeMandante() {
		return timeMandante;
	}
	public void setTimeMandante(Time timeMandante) {
		this.timeMandante = timeMandante;
	}
	public Time getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public boolean isTimeMandanteGol() {
		return timeMandanteGol;
	}
	public void setTimeMandanteGol(boolean timeMandanteGol) {
		this.timeMandanteGol = timeMandanteGol;
	}
	public boolean isTimeVisitanteGol() {
		return timeVisitanteGol;
	}
	public void setTimeVisitanteGol(boolean timeVisitanteGol) {
		this.timeVisitanteGol = timeVisitanteGol;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	
}
