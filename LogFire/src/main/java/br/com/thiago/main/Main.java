package br.com.thiago.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.thiago.config.PathDoLog;
import br.com.thiago.model.Jogador;
import br.com.thiago.service.BuildRanking;
import br.com.thiago.service.JogadorService;
import br.com.thiago.service.LeitorDeArquivoService;
import br.com.thiago.service.impl.BuildRankingPadrao;
import br.com.thiago.service.impl.JogadorServiceImpl;
import br.com.thiago.service.impl.LeitorDeArquivoImpl;
import br.com.thiago.service.impl.PontuacaoDosKillers;
import br.com.thiago.service.impl.PontuacaoDosMortos;

public class Main {

	public static void main(String[] args) {
		LeitorDeArquivoService leitorDeArquivo = new LeitorDeArquivoImpl();
		String textDoLog                    = leitorDeArquivo.ler(PathDoLog.Path.toString());
		JogadorService jogadorService       = new JogadorServiceImpl(leitorDeArquivo.quebrarLogEmLinhas(textDoLog));
		List<Jogador> jogadores             = new ArrayList<>();
		Jogador jogador;
		Map<String, Number> pontuacaoKills  = new HashMap<>();
		Map<String, Number> pontuacaoMortes = new HashMap<>();
		
		
		pontuacaoMortes = jogadorService.getPontuacao(new PontuacaoDosMortos());
		pontuacaoKills  =  jogadorService.getPontuacao(new PontuacaoDosKillers());

		
		for(String nome : jogadorService.mergeNomes(pontuacaoKills, pontuacaoMortes)){ // iterando em todo o log valido, montar lista de jogadores
			jogador = new Jogador();
			jogador.setNome(nome);
			
			if(pontuacaoMortes.get(nome)!= null)
			jogador.setQntDeMortes(pontuacaoMortes.get(nome).intValue());
			
			if(pontuacaoKills.get(nome)!= null)
			jogador.setQntDeKill(pontuacaoKills.get(nome).intValue());
			
			jogadores.add(jogador);
		}
		
		BuildRanking ranking = new BuildRankingPadrao(jogadores);
		ranking.build();
	}
}
