package va.suhano.coursework.Exceptions;

public class IncorrectAmountOfQuestionsException extends RuntimeException {
    public IncorrectAmountOfQuestionsException() {
    }

    public IncorrectAmountOfQuestionsException(String message) {
        super(message);
    }

    public IncorrectAmountOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectAmountOfQuestionsException(Throwable cause) {
        super(cause);
    }

    public IncorrectAmountOfQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
