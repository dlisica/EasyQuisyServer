package easyquisy.service;

import java.util.List;

import easyquisy.domain.QuizStatistics;
import easyquisy.dto.QuizResult;

public interface IQuizStatisticsService {

	List<QuizStatistics> getAllQuizStatistics();

	QuizStatistics getQuizStatistics(String quizId);

	QuizStatistics insertQuizStatistics(QuizStatistics quizStatistics);

	QuizStatistics updateQuizStatistics(QuizResult result);

}
