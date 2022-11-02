package liga.medical.personservice.core.exception;

public class NoUserRoleException extends Exception {
    public NoUserRoleException() {
        super();
    }

    public NoUserRoleException(String message) {
        super(message);
    }

    public NoUserRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserRoleException(Throwable cause) {
        super(cause);
    }

    protected NoUserRoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
