package liga.medical.personservice.core.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoElementInDbException extends Exception {

    public NoElementInDbException(String message) {
        super(message);
    }

    public NoElementInDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoElementInDbException(Throwable cause) {
        super(cause);
    }

    public NoElementInDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
