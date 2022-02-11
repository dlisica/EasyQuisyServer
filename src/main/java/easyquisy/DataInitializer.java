package easyquisy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import easyquisy.domain.Player;
import easyquisy.domain.Question;
import easyquisy.domain.Quiz;
import easyquisy.domain.QuizCategory;
import easyquisy.domain.QuizStatistics;
import easyquisy.service.IPlayerService;
import easyquisy.service.IQuizService;
import easyquisy.service.IQuizStatisticsService;

//@Component
public class DataInitializer {

	@Autowired
	private IQuizService quizService;

	@Autowired
	private IQuizStatisticsService quizStatisticsService;

	@Autowired
	private IPlayerService playerService;

	//@EventListener
	public void appReady(ApplicationReadyEvent event) {

		insertQuizzes();
		insertPlayers();

	}

	private void insertQuizzes() {

		Question q1, q2, q3, q4, q5;
		List<Question> questions;
		Quiz quiz;

		q1 = new Question("In which year did Croatia gain independence?", Arrays.asList("1918", "1945", "1991", "2006"),
				2);

		q2 = new Question("What was the name of the first croatian king?",
				Arrays.asList("Tomislav", "Zvonimir", "Drzislav", "Trpimir"), 0);

		q3 = new Question("What is ruling dynasty in Croatia before the fall of Croatian Kindgdom?",
				Arrays.asList("Kotromanici", "Karadordevici", "Trpimirovici", "Petrovici"), 2);

		q4 = new Question("Tito, former president of Yugoslavia, was born in Croatia. In which village?",
				Arrays.asList("Veliko Trgovisce", "Kumrovec", "Babina greda", "Trebarjevo Desno"), 1);

		q5 = new Question("In which year Croatian made union with Hungary (also knows as Pacta Conventa)?",
				Arrays.asList("1092", "1094", "1102", "1712"), 2);

		questions = Arrays.asList(q1, q2, q3, q4, q5);

		quiz = new Quiz("Croatian history", "Admin", QuizCategory.HISTORY, "Basic questions about croatian history",
				"https://cdn.pixabay.com/photo/2019/03/02/00/18/visovac-4028988_1280.jpg", questions);

		quiz = quizService.insertQuiz(quiz);
		quizStatisticsService.insertQuizStatistics(new QuizStatistics(quiz.getId()));

		// ------------

		q1 = new Question("Who was croatian author who got Nobel price in 1961?",
				Arrays.asList("Ivo Andric", "Miroslav Krleza", "Mesa Selimovic", "Antun Gustav Matos"), 0);

		q2 = new Question("Who was the most famous croatian female author for children?",
				Arrays.asList("Dubravka Ugresic", "Sanja Polak", "Sanja Pilic", "Ivana Brlic Mazuranic"), 3);

		q3 = new Question("What is the most famous novel by Miroslav Krleza published in 1932?", Arrays.asList(
				"Gospoda Glembayevi", "Povratak Filipa Latinovicza", "Na Drini cuprija", "Hrvatski bog Mars"), 1);

		q4 = new Question("Who was the author of the first Croatian grammar published in 1604?",
				Arrays.asList("Ivan Kukuljevic Sakcinski", "Ljudevit Gaj", "Faust Vrancic", "Bartol Kasic"), 3);

		q5 = new Question("In what script was the Bascanska ploca written?",
				Arrays.asList("Greek", "Latin", "Glagolitic", "Cyrillic"), 2);

		questions = Arrays.asList(q1, q2, q3, q4, q5);

		quiz = new Quiz("Croatian literature", "Admin", QuizCategory.LITERATURE,
				"Basic questions about croatian literature", "image.url", questions);

		quiz = quizService.insertQuiz(quiz);
		quizStatisticsService.insertQuizStatistics(new QuizStatistics(quiz.getId()));

		// ------------

		q1 = new Question("Who was the first croatian president?",
				Arrays.asList("Josip Broz Tito", "Franjo Tudman", "Stipe Mesic", "Ivica Racan"), 1);

		q2 = new Question("What is the name of croatian parlament?",
				Arrays.asList("Skupstina", "Duma", "Sabor", "Sobranje"), 2);

		q3 = new Question("On which Zagreb square are the most important institutions of the Croatian state located?",
				Arrays.asList("Markov trg", "Britanski trg", "Pantovcak", "Jelacicev trg"), 0);

		q4 = new Question("What is the name of only woman that held title of croatian prime minster?",
				Arrays.asList("Jadranka Kosor", "Kolinda Grabar Kitarovic", "Vesna Pusic", "Jasna Omejec"), 0);

		q5 = new Question("In which year Croatia joined EU?", Arrays.asList("2003", "2007", "2013", "2016"), 2);

		questions = Arrays.asList(q1, q2, q3, q4, q5);

		quiz = new Quiz("Croatian politics", "Admin", QuizCategory.POLITICS, "Basic questions about croatian politics",
				"image.url", questions);

		quiz = quizService.insertQuiz(quiz);
		quizStatisticsService.insertQuizStatistics(new QuizStatistics(quiz.getId()));

	}

	private void insertPlayers() {

		Player player;

		player = new Player("mkrleza@mail.hr", "Miroslav Krleza", "password", "2000-12-31");
		player = playerService.insertPlayer(player);

		player = new Player("agmatos@mail.hr", "Antun Gustav Matos", "password", "2005-12-31");
		player = playerService.insertPlayer(player);

		player = new Player("absimic@mail.hr", "Antun Branko Simic", "password", "2010-12-31");
		player = playerService.insertPlayer(player);

		player = new Player("iandric@mail.hr", "Ivo Andric", "password", "2015-12-31");
		player = playerService.insertPlayer(player);

		player = new Player("mmarulic@gmail.hr", "Marko Marulic", "password", "2020-12-31");
		player = playerService.insertPlayer(player);

	}

}
