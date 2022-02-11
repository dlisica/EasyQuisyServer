package easyquisy.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Quiz {

	@Id
	private String id;

	private String name;

	private String author;

	private QuizCategory category;

	private String description;

	private String imageUrl;

	private List<Question> questions;

	public Quiz(String name, String author, QuizCategory category, String description, String imageUrl,
			List<Question> questions) {
		super();
		this.name = name;
		this.author = author;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
		this.questions = questions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public QuizCategory getCategory() {
		return category;
	}

	public void setCategory(QuizCategory category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
