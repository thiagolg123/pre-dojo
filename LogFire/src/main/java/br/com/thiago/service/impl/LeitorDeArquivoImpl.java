package br.com.thiago.service.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.thiago.service.LeitorDeArquivoService;

public class LeitorDeArquivoImpl extends LeitorDeArquivoService {

	public String ler(String pathname) {
		byte[] byts = null;
		Charset encod = StandardCharsets.UTF_8; // UTF 8 como padrão
		try {
			byts = Files.readAllBytes(Paths.get(pathname));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encod.decode(ByteBuffer.wrap(byts)).toString();
	}
	
	
}
