package va.suhano.coursework;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import va.suhano.coursework.ExaminerService.ExaminerServiceImpl;
import va.suhano.coursework.Exceptions.IncorrectAmountOfQuestionsException;
import va.suhano.coursework.QuestionService.JavaQuestionService;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    private List <Question> questions;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;



    @BeforeEach
    public void beforeEach() {
        questions = List.of(
                new Question("Что такое метод?", "блок кода, который выполняет определенную функцию и позволяет переиспользовать себя в нескольких местах без необходимости снова писать один и тот же метод"),
                new Question("Что такое статический метод?", "метод, который принадлежит классу"),
                new Question("Что такое нестатический метод?", "метод, который принадлежит объекту")
        );
        when(javaQuestionService.getAll()).thenReturn(questions);
    }

    @Test
    public void getQuestionsTest() {

        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(2));

        Assertions.assertThat(examinerServiceImpl.getQuestions(2)).containsExactly(questions.get(0), questions.get(2));
    }

    @Test
    public void IncorrectAmountOfQuestionTest() {
        Assertions.assertThatExceptionOfType(IncorrectAmountOfQuestionsException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(0));
    }


}
