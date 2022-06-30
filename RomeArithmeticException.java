public class RomeArithmeticException extends Exception {   // создали все 5 конструкторов исключений
    public RomeArithmeticException() {
    }

    public RomeArithmeticException(String message) {
        super(message);
    }

    public RomeArithmeticException(String message, Throwable cause) {
        super(message, cause);
    }

    public RomeArithmeticException(Throwable cause) {
        super(cause);
    }

    public RomeArithmeticException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
