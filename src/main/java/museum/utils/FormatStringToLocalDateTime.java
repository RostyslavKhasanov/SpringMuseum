package museum.utils;

import java.time.LocalDateTime;

/**
 * Interface for formatting and parsing string to LocalDateTime.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public interface FormatStringToLocalDateTime {

  /**
   * Method for formatting and parsing string to LocalDateTime.
   *
   * @param value
   * @return LocalDateTime
   */
  LocalDateTime convertToLocalDateTime(String value);
}
