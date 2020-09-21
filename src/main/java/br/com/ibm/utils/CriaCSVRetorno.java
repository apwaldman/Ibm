package br.com.ibm.utils;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import br.com.ibm.domain.Arquivo;
import br.com.ibm.services.ReceitaServiceResultado;

public class CriaCSVRetorno {

	public void CriarCVS() {
		try {
			ReceitaServiceResultado resultadoReceitaService = new ReceitaServiceResultado();
			List<Arquivo> arquivoProcessado = resultadoReceitaService.LerArquivo();

			if (!arquivoProcessado.isEmpty()) {
				Writer writer = Files.newBufferedWriter(Paths.get("src\\\\main\\\\resources\\\\arquivoProcessado.csv"));
				StatefulBeanToCsv<Arquivo> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
				beanToCsv.write(arquivoProcessado);
				writer.flush();
				writer.close();
			} else {
				System.out.println("Não foi possível gerar o arquivo pois o retorno da interpretação está vazio.");
			}
		} catch (Exception e) {
			System.out.println("Erro na escrita do arquivo - classe CriaCSVRetorno");
		}
	}
}
