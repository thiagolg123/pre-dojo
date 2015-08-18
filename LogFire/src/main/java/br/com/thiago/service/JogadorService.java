package br.com.thiago.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface JogadorService {

	public List<String> getNomeJogadores(IdentificaNomeJogador inj);
	
	public Map<String, Number> getPontuacao(IdentificaNomeJogador inj);
	
	/**
	 * Retorna uma {@link Set} com os nomes da partida para montar o ranking 
	 * 
	 * @param pontuacaoKills
	 * @param pontuacaoMortes
	 * @return
	 */
	public Set<String> mergeNomes(Map<String, Number> pontuacaoKills, Map<String, Number> pontuacaoMortes);
}
