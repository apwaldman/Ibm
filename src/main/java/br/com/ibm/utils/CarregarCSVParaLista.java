package br.com.ibm.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.ibm.domain.Arquivo;


public class CarregarCSVParaLista {
	//Método que lê o arquivo cvs e carrega os dados numa lista
	public List<Arquivo> carregar(){
    	List <Arquivo> arquivoLista = new ArrayList <>();
		try {
		    String fileIn = "src\\main\\resources\\arquivo.csv";
		    String line;
		    String agencia;
			String conta;
			double saldo ;
			String status;		
		    FileReader fileReader = new FileReader(fileIn);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    NumberFormat nf = NumberFormat.getInstance();
		    while ((line = bufferedReader.readLine()) != null) {
		    	Arquivo arquivo = new Arquivo();
		    	String[] temp = line.split(";");
		        agencia = temp[0];
		        String novaAgencia = agencia.replaceAll("^[\"']+|[\"']+$", "");
		        arquivo.setAgencia(novaAgencia);
		        
		        conta = temp[1];
		        String novaConta = conta.replace("-", "");
		        arquivo.setConta(novaConta);
		        
		        saldo = nf.parse(temp[2]).doubleValue();;
		        arquivo.setSaldo(saldo);
		        
		        status = temp[3];
		        String novoStatus = status.replaceAll("^[\"']+|[\"']+$", "");
		        arquivo.setStatus(novoStatus);
		        arquivoLista.add(arquivo);
		    }
		    bufferedReader.close();
	
		} catch (Exception e) {
			System.out.println("Erro ao carregar arquivo para a lista na classe CarregarCSVParaLista");
		}
   	return arquivoLista;
	}
}