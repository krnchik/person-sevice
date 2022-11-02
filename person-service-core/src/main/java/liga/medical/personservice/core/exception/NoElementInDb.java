package liga.medical.personservice.core.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoElementInDb extends Exception {

    public NoElementInDb(String message) {
        super(message);
    }

    public NoElementInDb(String message, Throwable cause) {
        super(message, cause);
    }

    public NoElementInDb(Throwable cause) {
        super(cause);
    }

    public NoElementInDb(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
