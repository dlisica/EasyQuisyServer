package easyquisy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class QuizStatistics {

	@Id
	private String quizId;

	private int numberOfPlays;

	private int averageResult;

	private double averagePlayingTime;

	public QuizStatistics(String quizId) {
		this.quizId = quizId;
		numberOfPlays = 0;
		averageResult = 0;
		averagePlayingTime = 0.0;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public int getNumberOfPlays() {
		return numberOfPlays;
	}

	public void setNumberOfPlays(int numberOfPlays) {
		this.numberOfPlays = numberOfPlays;
	}

	public double getAverageResult() {
		return averageResult;
	}

	public void setAverageResult(int averageResult) {
		this.averageResult = averageResult;
	}

	public double getAveragePlayingTime() {
		return averagePlayingTime;
	}

	public void setAveragePlayingTime(double averagePlayingTime) {
		this.averagePlayingTime = averagePlayingTime;
	}

}
