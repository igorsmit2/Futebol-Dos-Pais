package br.usjt.ads.futebol.model.entity;

public class Campeonato {
	private int id;
	private String nome;
	private int quantidadeTimes;
	private int quantidadeRodadas, quantidadeTurno;
	private int pontosVitoria, pontosEmpate, pontosDerrota;
	
	public int getQuantidadeTurno() {
		return quantidadeTurno;
	}
	public void setQuantidadeTurno(int quantidadeTurno) {
		this.quantidadeTurno = quantidadeTurno;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadeTimes() {
		return quantidadeTimes;
	}
	public void setQuantidadeTimes(int quantidadeTimes) {
		this.quantidadeTimes = quantidadeTimes;
	}
	public int getQuantidadeRodadas() {
		return quantidadeRodadas;
	}
	public void setQuantidadeRodadas(int quantidadeRodadas) {
		this.quantidadeRodadas = quantidadeRodadas;
	}
	public int getPontosVitoria() {
		return pontosVitoria;
	}
	public void setPontosVitoria(int pontosVitoria) {
		this.pontosVitoria = pontosVitoria;
	}
	public int getPontosEmpate() {
		return pontosEmpate;
	}
	public void setPontosEmpate(int pontosEmpate) {
		this.pontosEmpate = pontosEmpate;
	}
	public int getPontosDerrota() {
		return pontosDerrota;
	}
	public void setPontosDerrota(int pontosDerrota) {
		this.pontosDerrota = pontosDerrota;
	}
	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", nome=" + nome + ", quantidadeTimes=" + quantidadeTimes
				+ ", quantidadeRodadas=" + quantidadeRodadas + ", pontosVitoria=" + pontosVitoria + ", pontosEmpate="
				+ pontosEmpate + ", pontosDerrota=" + pontosDerrota + "]";
	}
	
	
	
}
