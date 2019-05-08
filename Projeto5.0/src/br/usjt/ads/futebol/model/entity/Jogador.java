package br.usjt.ads.futebol.model.entity;

public class Jogador {
	private int id;
	private String apelido;
	private String fotoJogador;
	private boolean capitao;
	private Categoria categoria;
	private Posicao posicao;
	private Time time;
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getFotoJogador() {
		return fotoJogador;
	}
	public void setFotoJogador(String fotoJogador) {
		this.fotoJogador = fotoJogador;
	}
	public boolean isCapitao() {
		return capitao;
	}
	public void setCapitao(boolean capitao) {
		this.capitao = capitao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	@Override
	public String toString() {
		return "Jogador [id=" + id + ", apelido=" + apelido + ", fotoJogador=" + fotoJogador + ", capitao=" + capitao
				+ ", categoria=" + categoria + ", posicao=" + posicao + ", time=" + time + "]";
	}
	
	
	
}
