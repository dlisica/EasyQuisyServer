package easyquisy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

	@Id
	private String id;

	private String emailAdress;

	private String username;

	private String password;

	private String dateOfRegistration;

	private int numberOfPlays;

	private int averageScore;

	private double averagePlayingTime;

	public Player(String emailAdress, String username, String password, String dateOfRegistration) {
		this.emailAdress = emailAdress;
		this.username = username;
		this.password = password;
		this.dateOfRegistration = dateOfRegistration;
		this.numberOfPlays = 0;
		this.averageScore = 0;
		this.averagePlayingTime = 0.0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public int getNumberOfPlays() {
		return numberOfPlays;
	}

	public void setNumberOfPlays(int numberOfPlays) {
		this.numberOfPlays = numberOfPlays;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	public double getAveragePlayingTime() {
		return averagePlayingTime;
	}

	public void setAveragePlayingTime(double averagePlayingTime) {
		this.averagePlayingTime = averagePlayingTime;
	}

}
