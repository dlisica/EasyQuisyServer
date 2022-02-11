package easyquisy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import easyquisy.domain.Quiz;
import easyquisy.domain.QuizStatistics;
import easyquisy.service.IQuizService;
import easyquisy.service.IQuizStatisticsService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private IQuizService quizService;

	@Autowired
	private IQuizStatisticsService quizStatisticsService;

	@GetMapping("")
	public ResponseEntity<List<Quiz>> getAllQuizzes() {
		List<Quiz> list = quizService.getAllQuizzes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/id/{quizId}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable("quizId") String quizId) {
		Quiz quiz = quizService.getQuiz(quizId);

		if (quiz != null)
			return new ResponseEntity<>(quiz, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/insert")
	public ResponseEntity<Quiz> insertQuiz(@RequestBody Quiz quiz) {
		quiz = quizService.insertQuiz(quiz);
		quizStatisticsService.insertQuizStatistics(new QuizStatistics(quiz.getId()));
		return new ResponseEntity<>(quiz, HttpStatus.OK);
	}

	// statistics mappings

	@GetMapping("/stat")
	public ResponseEntity<List<QuizStatistics>> getAllQuizStatistics() {
		List<QuizStatistics> list = quizStatisticsService.getAllQuizStatistics();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/stat/id/{quizId}")
	public ResponseEntity<QuizStatistics> getQuizStatisticsById(@PathVariable("quizId") String quizId) {
		QuizStatistics statistics = quizStatisticsService.getQuizStatistics(quizId);

		if (statistics != null)
			return new ResponseEntity<>(statistics, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
