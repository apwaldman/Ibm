package br.com.ibm.utils;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.com.ibm.domain.Arquivo;
import br.com.ibm.services.ReceitaServiceResultado;

public class CriaCSVRetorno {

	public void CriarCVS() throws IOException, ParseException, RuntimeException, InterruptedException,
			CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		ReceitaServiceResultado resultadoReceitaService = new ReceitaServiceResultado();
		List<Arquivo> arquivoProcessado = resultadoReceitaService.LerArquivo();

		Writer writer = Files.newBufferedWriter(Paths.get("src\\\\main\\\\resources\\\\arquivoProcessado.csv"));
		StatefulBeanToCsv<Arquivo> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

		beanToCsv.write(arquivoProcessado);
		writer.flush();
		writer.close();
	}
}
