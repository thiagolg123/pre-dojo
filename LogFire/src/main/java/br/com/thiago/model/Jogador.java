package br.com.thiago.model;

public class Jogador {

	private String nome;
	private int qntDeKill;
	private int qntDeMortes;

	public int getQntDeKill() {
		return qntDeKill;
	}

	public void setQntDeKill(int qntDeKill) {
		this.qntDeKill = qntDeKill;
	}

	public int getQntDeMortes() {
		return qntDeMortes;
	}

	public void setQntDeMortes(int qntDeMortes) {
		this.qntDeMortes = qntDeMortes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
