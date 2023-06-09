package va.suhano.coursework.ExaminerService;

import org.springframework.stereotype.Service;
import va.suhano.coursework.Exceptions.IncorrectAmountOfQuestionsException;
import va.suhano.coursework.Question;
import va.suhano.coursework.QuestionService.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new IncorrectAmountOfQuestionsException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}

