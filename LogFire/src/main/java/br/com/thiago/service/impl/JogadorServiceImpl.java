package br.com.thiago.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.thiago.service.IdentificaNomeJogador;
import br.com.thiago.service.JogadorService;

/**
 * Service para regras de negocio do jogador;
 * 
 * @author thiago
 * 
 */
public class JogadorServiceImpl implements JogadorService {

	private String[] logEditado = null;

	/**
	 * @param Passar o log do jogo no formato padrao: quebrado nos enters(\r\n);
	 */
	public JogadorServiceImpl(String[] log) {
		this.logEditado = log;
	}

	@Override
	public List<String> getNomeJogadores(IdentificaNomeJogador inj) {
		return inj.getNome(logEditado);
	}


	@Override
	public Map<String, Number> getPontuacao(IdentificaNomeJogador inj) {
		Map<String, Number> pontuacao = new HashMap<>();

		List<String> nomesPorTipoDePontuacao = getNomeJogadores(inj);

		for (String nome : nomesPorTipoDePontuacao) {
			pontuacao.put(nome, Collections.frequency(nomesPorTipoDePontuacao, nome));
		}
		return pontuacao;
	}
	
	public Set<String> mergeNomes(Map<String, Number> pontuacaoKills, Map<String, Number> pontuacaoMortes){
		Set<String> nomeMortos  = pontuacaoMortes.keySet();
		Set<String> nomeKillers = pontuacaoKills.keySet();
		Set<String> todosNomes  = new HashSet<String>();
		todosNomes.addAll(nomeKillers);
		todosNomes.addAll(nomeMortos);
		
		return todosNomes;
	}
}
