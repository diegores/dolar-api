package br.com.bb.desafio.utils;

import br.com.bb.desafio.exception.DolarQuoteErrorImpossibleToConverterDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DolarQuoteUtils {

    public static String convertDate(String inputDate) {
        // Parse a data de entrada no formato yyyy-MM-dd
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(inputDate, inputFormatter);

        // Formate a data no novo formato MM-dd-yyyy
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return localDate.format(outputFormatter);
    }

    public static LocalDate convertToLocaldate(String value, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(value, formatter);
    }
}
