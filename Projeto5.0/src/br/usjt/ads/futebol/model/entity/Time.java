package br.usjt.ads.futebol.model.entity;

public class Time {
	private int id;
	private String nome;
	private String emblema;
	private String coordenador;
	private String fotoEquipe;
	
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
	public String getEmblema() {
		return emblema;
	}
	public void setEmblema(String emblema) {
		this.emblema = emblema;
	}
	public String getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	public String getFotoEquipe() {
		return fotoEquipe;
	}
	public void setFotoEquipe(String fotoEquipe) {
		this.fotoEquipe = fotoEquipe;
	}
	
	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", emblema=" + emblema + ", coordenador=" + coordenador
				+ ", fotoEquipe=" + fotoEquipe + "]";
	}
	
}
