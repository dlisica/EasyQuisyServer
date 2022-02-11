package easyquisy.domain;

import java.util.List;

public class Question {

	private String question;

	private List<String> answers;

	private int correctAnswer;

	public Question(String question, List<String> answers, int correctAnswer) {

		this.question = question;

		String correctAns = answers.get(correctAnswer);
		answers.sort((a1, a2) -> a1.compareTo(a2));
		
		this.answers = answers;
		this.correctAnswer = this.answers.indexOf(correctAns);

		if (correctAnswer == -1)
			throw new IllegalArgumentException("Something is wrong with answers!");

	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
