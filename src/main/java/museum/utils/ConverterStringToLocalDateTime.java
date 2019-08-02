package museum.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConverterStringToLocalDateTime {

    private static  final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public LocalDateTime convertToDate(String input) {
        return LocalDateTime.parse(input.replace("T", " "), formatter);
    }
}
