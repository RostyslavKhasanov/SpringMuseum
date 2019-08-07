package museum.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Component implementation for formatting and parsing logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Component
@AllArgsConstructor
public class FormatStringToLocalDateTimeImpl implements FormatStringToLocalDateTime {

  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

  /**
   * Method with logic for formatting and parsing string to LocalDateTime.
   *
   * @param value String
   * @return LocalDateTime
   */
  public LocalDateTime convertToLocalDateTime(String value) {
    return LocalDateTime.parse(value, DATE_TIME_FORMATTER);
  }
}
