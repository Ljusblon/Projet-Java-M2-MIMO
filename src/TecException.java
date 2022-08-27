package tec;

// Cette classe permet de contrôler les exceptions et sert principalement pour les tests.
@SuppressWarnings("serial")
public class TecException extends Exception {
    TecException(String message) {
        super(message);
    }

    TecException(Throwable cause) {
        super(cause);
    }
}