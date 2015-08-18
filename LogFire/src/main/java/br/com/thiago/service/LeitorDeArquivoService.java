package br.com.thiago.service;

public abstract class LeitorDeArquivoService {
	
	/**
	 * Le arquivo conforme o path especificado;
	 * 
	 * @param pathname
	 * @return retorna conteudo do arquivo
	 * <br> null se não achar o arquivo;
	 */
	public abstract String ler(String pathname);
	
	
	/**
	 * @return Devolve o log "quebrado nos enters(\r\n)"
	 */
	public String[] quebrarLogEmLinhas(String log) {
		return log.split("\r\n");
	}
}
