package easyquisy.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import easyquisy.domain.QuizStatistics;

public interface QuizStatisticsRepository extends MongoRepository<QuizStatistics, String> {

	//QuizStatistics findByQuizId(String quizId);

}
