package br.usjt.ads.futebol.model.entity;

import java.util.Date;

public class Partida {
	private Time timeMandante, timeVisitante;
	private Campeonato campeonato;
	private int rodada;
	private Date dataPartida;
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
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
}	
