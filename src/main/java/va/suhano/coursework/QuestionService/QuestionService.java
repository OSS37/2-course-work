package va.suhano.coursework.QuestionService;

import va.suhano.coursework.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);


    Question remove(Question question);

    Collection <Question> getAll();

    public Question getRandomQuestion();
}
