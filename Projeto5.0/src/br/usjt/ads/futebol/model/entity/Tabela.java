package br.usjt.ads.futebol.model.entity;

public class Tabela {
	private Time time;
	private Campeonato campeonato;
	private int vitoria, derrota, empate, golPro, golContra;
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public int getVitoria() {
		return vitoria;
	}
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}
	public int getDerrota() {
		return derrota;
	}
	public void setDerrota(int derrota) {
		this.derrota = derrota;
	}
	public int getEmpate() {
		return empate;
	}
	public void setEmpate(int empate) {
		this.empate = empate;
	}
	public int getGolPro() {
		return golPro;
	}
	public void setGolPro(int golPro) {
		this.golPro = golPro;
	}
	public int getGolContra() {
		return golContra;
	}
	public void setGolContra(int golContra) {
		this.golContra = golContra;
	}
}
