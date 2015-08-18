package br.com.thiago.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.thiago.service.IdentificaNomeJogador;

public class PontuacaoDosMortos implements IdentificaNomeJogador {
	private List<String> nomesJogadores = new ArrayList<>();
	private String nomeMorto = null;

	@Override
	public List<String> getNome(String[] log) { // substring até killed, soma 6
												// para excluir a palavra killed
		for (String linha : log) {
			if (linha.indexOf("killed") > 1) {
				nomeMorto = (linha.substring((linha.indexOf("killed") + 6))).split("using")[0].toString().trim();
				
				if (linha.substring(22, linha.indexOf("killed")).trim().equalsIgnoreCase("<WORLD>")) { //identificando o World
					nomeMorto = (linha.substring((linha.indexOf("killed") + 6)))
							.split("by")[0].toString().trim();
				}
				nomesJogadores.add(nomeMorto);
			}
		}
		return nomesJogadores;
	}

}
