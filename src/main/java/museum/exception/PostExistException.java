package museum.exception;

public class PostExistException extends RuntimeException {
  public PostExistException(String message) {
    super(message);
  }
}
