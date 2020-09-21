package br.com.ibm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.ibm.utils.CriaCSVRetorno;

public class Inicio {

	public static void main(String[] args) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
			CriaCSVRetorno criaCSV = new CriaCSVRetorno();
			if (date.getHours() >= 9 && date.getHours() <= 10) {
				criaCSV.CriarCVS();
				System.out
						.println("Arquivo de retorno disponível em: src\\\\main\\\\resources\\\\arquivoProcessado.csv");
			} else {			
				System.out.println(
						"O sistema está configurado para ser executado entre as 9 e 10h. Para executar fora desse horário, ajuste os parâmetros");
			}
		} catch (Exception e) {
			System.out.println("Erro na execução do sistema.");
		}
	}
}
