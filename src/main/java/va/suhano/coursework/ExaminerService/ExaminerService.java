package va.suhano.coursework.ExaminerService;

import va.suhano.coursework.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection <Question> getQuestions(int amount);
}
