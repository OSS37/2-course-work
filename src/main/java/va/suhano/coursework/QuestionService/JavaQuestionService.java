package va.suhano.coursework.QuestionService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import va.suhano.coursework.Exceptions.QuestionAlredyExistsExeption;
import va.suhano.coursework.Exceptions.QuestionNotFoundException;
import va.suhano.coursework.Question;

import java.util.*;
@Component
@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionsSet = new HashSet<>();



    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionsSet.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questionsSet.contains(question)) {
            throw new QuestionAlredyExistsExeption() ;
        }
        questionsSet.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (questionsSet.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questionsSet);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return new ArrayList<>(questionsSet).get(random.nextInt(questionsSet.size()));
    }


}
