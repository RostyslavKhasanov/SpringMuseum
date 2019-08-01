package museum.exception;

/**
 * Exception for bad request name for date input.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class BadRequestForInputDate extends RuntimeException {
    public BadRequestForInputDate(String message) {
        super(message);
    }
}
