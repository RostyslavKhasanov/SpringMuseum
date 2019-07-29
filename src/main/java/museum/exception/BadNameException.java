package museum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Worker")
public class BadNameException extends RuntimeException {
  public BadNameException(String message) {
    super(message);
  }
}
