package easyquisy.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easyquisy.dao.PlayerRepository;
import easyquisy.domain.Player;
import easyquisy.dto.QuizResult;
import easyquisy.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayerById(String playerId) {
		Optional<Player> optionalPlayer = playerRepository.findById(playerId);
		return optionalPlayer.isPresent() ? optionalPlayer.get() : null;
	}

	@Override
	public Player getPlayerByUsername(String username) {
		Optional<Player> optionalPlayer = playerRepository.findByUsername(username);
		return optionalPlayer.isPresent() ? optionalPlayer.get() : null;
	}

	@Override
	public Player insertPlayer(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player updatePlayerStatistics(QuizResult result) {
		Optional<Player> optionalPlayer = playerRepository.findById(result.getPlayerId());

		if (optionalPlayer.isEmpty())
			return null;

		Player player = optionalPlayer.get();

		int numberOfPlays = player.getNumberOfPlays();
		double averageScore = player.getAverageScore();
		double averagePlayingTime = player.getAveragePlayingTime();

		player.setAverageScore((int) ((numberOfPlays * averageScore + result.getScore()) / (numberOfPlays + 1)));
		player.setAveragePlayingTime(
				(numberOfPlays * averagePlayingTime + result.getPlayingTime()) / (numberOfPlays + 1));
		player.setNumberOfPlays(numberOfPlays + 1);

		player = playerRepository.save(player);

		return player;
	}

	@Override
	public List<Player> getLeaderboard() {
		return playerRepository.findAll().stream()
				.sorted((p1, p2) -> Integer.valueOf(p2.getAverageScore()).compareTo(p1.getAverageScore())).toList();

	}

	@Override
	public Player changePassword(String playerId, String oldPassword, String newPassword) {
		if (oldPassword.equals(newPassword))
			return null;

		Optional<Player> optionalPlayer = playerRepository.findById(playerId);

		if (optionalPlayer.isEmpty())
			return null;

		Player player = optionalPlayer.get();

		if (!player.getPassword().equals(oldPassword))
			return null;

		player.setPassword(newPassword);
		player = playerRepository.save(player);

		return player;
	}

}
