package br.com.thiago.model;

import java.util.Comparator;

public class JogadorComparator implements Comparator<Jogador>{

	@Override
	public int compare(Jogador j1, Jogador j2) {
		if(j1.getQntDeKill() > j2.getQntDeKill()){
			return -1;
		}
		if(j1.getQntDeKill() < j2.getQntDeKill()){
			return 1;
		}
		return 0;
	}
}
