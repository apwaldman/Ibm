package br.com.ibm.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.ibm.domain.Arquivo;
import br.com.ibm.utils.CarregarCSVParaLista;

public class ReceitaServiceResultado {
	ReceitaService receitaService = new ReceitaService();
	CarregarCSVParaLista carregarCSV = new CarregarCSVParaLista();
	
	public List<Arquivo> LerArquivo() throws IOException, ParseException, RuntimeException, InterruptedException {
		List<Arquivo> arquivo = carregarCSV.carregar();
		List<Arquivo> listaDeRetorno = new ArrayList<>();	
		
		for (Arquivo arquivo2 : arquivo) {
			Arquivo arquivoComRetorno = new Arquivo();
			if (receitaService.atualizarConta(arquivo2.getAgencia(), arquivo2.getConta(), arquivo2.getSaldo(),
					arquivo2.getStatus())) {
				arquivoComRetorno.setAgencia(arquivo2.getAgencia());
				arquivoComRetorno.setConta(arquivo2.getConta());
				arquivoComRetorno.setSaldo(arquivo2.getSaldo());
				arquivoComRetorno.setStatus(arquivo2.getStatus());
				arquivoComRetorno.setResultado("True");
				listaDeRetorno.add(arquivoComRetorno);
			} else {		
				arquivoComRetorno.setAgencia(arquivo2.getAgencia());
				arquivoComRetorno.setConta(arquivo2.getConta());
				arquivoComRetorno.setSaldo(arquivo2.getSaldo());
				arquivoComRetorno.setStatus(arquivo2.getStatus());
				arquivoComRetorno.setResultado("False");
				listaDeRetorno.add(arquivoComRetorno);
			}			
		}		
		return listaDeRetorno;
	}
	
}
