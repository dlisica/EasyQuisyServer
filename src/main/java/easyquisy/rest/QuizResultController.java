package easyquisy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import easyquisy.dto.QuizResult;
import easyquisy.service.IPlayerService;
import easyquisy.service.IQuizStatisticsService;

@RestController
@RequestMapping("/result")
public class QuizResultController {

	@Autowired
	private IQuizStatisticsService quizStatisticsService;

	@Autowired
	private IPlayerService playerService;

	@PostMapping("")
	public ResponseEntity<QuizResult> insertQuizResult(@RequestBody QuizResult result) {
		playerService.updatePlayerStatistics(result);
		quizStatisticsService.updateQuizStatistics(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
