package va.suhano.coursework;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import va.suhano.coursework.Exceptions.QuestionAlredyExistsExeption;
import va.suhano.coursework.Exceptions.QuestionNotFoundException;
import va.suhano.coursework.QuestionService.JavaQuestionService;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        javaQuestionService.add("Что такое метод?", "блок кода, который выполняет определенную функцию и позволяет переиспользовать себя в нескольких местах без необходимости снова писать один и тот же метод");
        javaQuestionService.add("Что такое статический метод?", "метод, который принадлежит классу");
        javaQuestionService.add("Что такое нестатический метод?", "метод, который принадлежит объекту");
    }

    @AfterEach
    public void afterEach() {
        javaQuestionService.getAll()
                .forEach(question -> javaQuestionService.remove(question));
    }

    @Test
    public void addTest() {
        Question expected = new Question("Что такое стрим", "объект для универсальной работы с данным");
        Assertions.assertThat(javaQuestionService.add("Что такое стрим", "объект для универсальной работы с данным"))
                .isEqualTo(expected)
                .isIn(javaQuestionService.getAll());
    }

    @Test
    public void addWhenAlreadyExistsTest() {
        Question newQuestion = new Question("Что такое статический метод?", "метод, который принадлежит классу");

        Assertions.assertThatExceptionOfType(QuestionAlredyExistsExeption.class)
                .isThrownBy(() -> javaQuestionService.add(newQuestion));
    }

    @Test
    public void removeTest() {
        Question expected = new Question("Что такое JUnit?", "основной фреймворк для модульных тестов на Java");
        javaQuestionService.add(expected);
        Assertions.assertThat(javaQuestionService.remove(expected))
                .isNotIn(javaQuestionService.getAll());
    }

    @Test
    public void removeWhenNotFoundTest() {
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.remove(null));
    }

    @Test
    public void getAllTest() {
        Assertions.assertThat(javaQuestionService.getAll())
                .containsExactly(
                        new Question("Что такое метод?", "блок кода, который выполняет определенную функцию и позволяет переиспользовать себя в нескольких местах без необходимости снова писать один и тот же метод"),
                        new Question("Что такое статический метод?", "метод, который принадлежит классу"),
                        new Question("Что такое нестатический метод?", "метод, который принадлежит объекту")
                );
    }
    @Test
    public void getRandomQuestionTest (){
        Assertions.assertThat(javaQuestionService.getRandomQuestion())
                .isIn(javaQuestionService.getAll());

    }

}


