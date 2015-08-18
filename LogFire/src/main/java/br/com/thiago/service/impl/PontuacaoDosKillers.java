package br.com.thiago.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.thiago.service.IdentificaNomeJogador;

public class PontuacaoDosKillers implements IdentificaNomeJogador {
	private List<String> nomesJogadores = new ArrayList<>();
	private String tmp = null;
	
	@Override
	public List<String> getNome(String[] log) {
		for (String linha : log) {
			if (linha.indexOf("killed") > 1) {
				tmp = linha.substring(22, linha.indexOf("killed")).toString().trim();
				
				if(!tmp.equals("<WORLD>")) nomesJogadores.add(tmp);
			}
		}
			
		return nomesJogadores;
	}

}
