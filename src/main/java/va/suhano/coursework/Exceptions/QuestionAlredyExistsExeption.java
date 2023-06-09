package va.suhano.coursework.Exceptions;

public class QuestionAlredyExistsExeption extends RuntimeException {
    public QuestionAlredyExistsExeption() {
    }

    public QuestionAlredyExistsExeption(String message) {
        super(message);
    }

    public QuestionAlredyExistsExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlredyExistsExeption(Throwable cause) {
        super(cause);
    }

    public QuestionAlredyExistsExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
