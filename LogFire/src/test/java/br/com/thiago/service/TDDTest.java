package br.com.thiago.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.thiago.config.PathDoLog;
import br.com.thiago.model.Jogador;
import br.com.thiago.service.impl.BuildRankingPadrao;
import br.com.thiago.service.impl.PontuacaoDosKillers;
import br.com.thiago.service.impl.PontuacaoDosMortos;
import br.com.thiago.service.impl.JogadorServiceImpl;
import br.com.thiago.service.impl.LeitorDeArquivoImpl;

public class TDDTest {

	private String textDoLog = null;
	private LeitorDeArquivoService leitor = null;
	private JogadorService jogadorService = null;

	@Before
	public void init() {
		leitor = new LeitorDeArquivoImpl();
		textDoLog = leitor.ler(PathDoLog.Path.toString());
		jogadorService = new JogadorServiceImpl(leitor.quebrarLogEmLinhas(textDoLog));
	}
	

	/**
	 * trocar o numero de linhas para validar o teste
	 */
	@Test
	public void deveQuebrarOLogEmLinhas() {
		assertEquals(9, leitor.quebrarLogEmLinhas(textDoLog).length);
	}

	@Test
	public void deveLerOArquivoDeLog() {
		System.out.println(textDoLog);
		assertNotNull(textDoLog);
	}

	/**
	 * O teste é validado conforme o primeiro matador
	 */
	@Test
	public void deveIdentificarOsJogadoresMatadores() {
		assertEquals("Thiago", jogadorService.getNomeJogadores(new PontuacaoDosKillers()).get(0));
	}

	/**
	 * O teste é validado conforme o primeiro morto
	 */
	@Test
	public void deveIdentificarOsJogadoresMortos() {
		assertEquals("Ademir jose", jogadorService.getNomeJogadores(new PontuacaoDosMortos()).get(0));
	}

	@Test
	public void deveSomarKillsPorJogador() {
		Map<String, Number> nAssassinatos = jogadorService.getPontuacao(new PontuacaoDosKillers());
		assertEquals(2, nAssassinatos.get("Thiago").intValue());
	}
	
	@Test
	public void deveSomarMortesPorJogador() {
		Map<String, Number> nAssassinatos = jogadorService.getPontuacao(new PontuacaoDosMortos());
		assertEquals(3, nAssassinatos.get("Thiago").intValue());
	}

	@Test
	public void deveConstruirRanking() {
		List<Jogador> jogadores = new ArrayList<>();
		Jogador jogador = null;
		
		for(int i=0; i<15; i++){ //Mockando Jogadores
			jogador = new Jogador();
			
			jogador.setNome("Play"+i);
			jogador.setQntDeKill(((Double)(Math.random()*i)).intValue());
			jogador.setQntDeMortes(((Double)(Math.random()*i)).intValue());
			
			jogadores.add(jogador);
		}
		
		BuildRanking buildRankingPadrao = new BuildRankingPadrao(jogadores);
		buildRankingPadrao.build();
		
		assertNotNull(buildRankingPadrao); // teste podera ser visto no log
	}
}
