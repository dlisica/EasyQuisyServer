package easyquisy.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easyquisy.dao.QuizStatisticsRepository;
import easyquisy.domain.QuizStatistics;
import easyquisy.dto.QuizResult;
import easyquisy.service.IQuizStatisticsService;

@Service
public class QuizStatisticsService implements IQuizStatisticsService {

	@Autowired
	private QuizStatisticsRepository quizStatisticsRepository;

	@Override
	public List<QuizStatistics> getAllQuizStatistics() {
		return quizStatisticsRepository.findAll();
	}

	@Override
	public QuizStatistics getQuizStatistics(String quizId) {
		Optional<QuizStatistics> optionalStatistics = quizStatisticsRepository.findById(quizId);
		return optionalStatistics.isPresent() ? optionalStatistics.get() : null;
	}

	@Override
	public QuizStatistics insertQuizStatistics(QuizStatistics quizStatistics) {
		return quizStatisticsRepository.save(quizStatistics);
	}

	@Override
	public QuizStatistics updateQuizStatistics(QuizResult result) {
		Optional<QuizStatistics> optionalStatistics = quizStatisticsRepository.findById(result.getQuizId());

		if (optionalStatistics.isEmpty())
			return null;

		QuizStatistics statistics = optionalStatistics.get();

		// newAverage = (size * average + value) / (size + 1)

		int numberOfPlays = statistics.getNumberOfPlays();
		double averageResult = statistics.getAverageResult();
		double averagePlayingTime = statistics.getAveragePlayingTime();

		statistics.setAverageResult((int) ((numberOfPlays * averageResult + result.getScore()) / (numberOfPlays + 1)));
		statistics.setAveragePlayingTime(
				(numberOfPlays * averagePlayingTime + result.getPlayingTime()) / (numberOfPlays + 1));
		statistics.setNumberOfPlays(numberOfPlays + 1);

		statistics = quizStatisticsRepository.save(statistics); // save problem: quizId != Object id ???

		return statistics;
	}

}
