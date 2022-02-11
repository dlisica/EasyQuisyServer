package easyquisy.dto;

public class QuizResult {

	private String playerId;

	private String quizId;

	private double playingTime;

	private int score;

	public QuizResult(String playerId, String quizId, long playingTime, int score) {
		super();
		this.playerId = playerId;
		this.quizId = quizId;
		this.playingTime = playingTime;
		this.score = score;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public double getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(long playingTime) {
		this.playingTime = playingTime;
	}

	public double getScore() {
		return score;
	}

	public void setNumberOfCorrectAnswers(int score) {
		this.score = score;
	}

}
