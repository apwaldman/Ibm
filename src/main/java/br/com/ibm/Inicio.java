package br.com.ibm;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import br.com.ibm.utils.CriaCSVRetorno;

public class Inicio {

	public static void main(String[] args) throws IOException, ParseException, RuntimeException, InterruptedException,
			CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

		if (date.getHours() >= 9 && date.getHours() <= 10) {
			CriaCSVRetorno criaCSV = new CriaCSVRetorno();
			criaCSV.CriarCVS();

		}
	}
}