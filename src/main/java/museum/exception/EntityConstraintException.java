package museum.exception;

public class EntityConstraintException extends RuntimeException {
    public EntityConstraintException() {
    }

    public EntityConstraintException(String message) {
        super(message);
    }
}
