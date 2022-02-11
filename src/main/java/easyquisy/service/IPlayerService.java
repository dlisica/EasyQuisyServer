package easyquisy.service;

import java.util.List;

import easyquisy.domain.Player;
import easyquisy.dto.QuizResult;

public interface IPlayerService {

	List<Player> getAllPlayers();

	Player getPlayerById(String playerId);

	Player getPlayerByUsername(String username);

	Player insertPlayer(Player player);

	Player updatePlayerStatistics(QuizResult result);

	List<Player> getLeaderboard();

	Player changePassword(String playerId, String oldPassword, String newPassword);

}
