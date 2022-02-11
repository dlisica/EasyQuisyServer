package easyquisy.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easyquisy.dao.QuizRepository;
import easyquisy.domain.Quiz;
import easyquisy.service.IQuizService;

@Service
public class QuizService implements IQuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public List<Quiz> getAllQuizzes() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz getQuiz(String quizId) {
		Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
		return optionalQuiz.isPresent() ? optionalQuiz.get() : null;
	}

	@Override
	public Quiz insertQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

}
