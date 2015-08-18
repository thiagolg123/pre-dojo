package br.com.thiago.service.impl;

import java.util.Collections;
import java.util.List;

import br.com.thiago.model.Jogador;
import br.com.thiago.model.JogadorComparator;
import br.com.thiago.service.BuildRanking;

/**
 * Constroi Ranking usando system out, ordenado pela contidade de kills de cada jogador
 * 
 * @author Thiago Gonçalves
 *
 */
public class BuildRankingPadrao implements BuildRanking{

	List<Jogador> jogadoresParaRanking = null;

	public BuildRankingPadrao(List<Jogador> jogadores) {
		this.jogadoresParaRanking = jogadores;
	}

	public void build() {
		Collections.sort(jogadoresParaRanking, new JogadorComparator());

		for (Jogador jogador : jogadoresParaRanking) {
			System.out.println("Nome:" + jogador.getNome() +
					"---- Kills:"+ jogador.getQntDeKill()  +
					"---- Mortes"+ jogador.getQntDeMortes());
		}
	}

}
