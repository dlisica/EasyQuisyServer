package easyquisy.service;

import java.util.List;

import easyquisy.domain.Quiz;

public interface IQuizService {

	List<Quiz> getAllQuizzes();

	Quiz getQuiz(String quizId);

	Quiz insertQuiz(Quiz quiz);

}
