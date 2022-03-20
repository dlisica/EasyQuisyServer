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

import easyquisy.domain.Player;
import easyquisy.dto.ChangePasswordRequest;
import easyquisy.dto.LoginRequest;
import easyquisy.service.implementation.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("")
	public ResponseEntity<List<Player>> getAllPlayers() {
		List<Player> list = playerService.getAllPlayers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/id/{playerId}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("playerId") String playerId) {
		Player player = playerService.getPlayerById(playerId);

		if (player != null)
			return new ResponseEntity<>(player, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/insert")
	public ResponseEntity<Player> insertPlayer(@RequestBody Player player) {
		Player existingPlayer = playerService.getPlayerByUsername(player.getUsername());

		if (existingPlayer != null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		player = playerService.insertPlayer(player);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@GetMapping("/leaderboard")
	public ResponseEntity<List<Player>> getLeaderboard() {
		List<Player> leaderboard = playerService.getLeaderboard();
		return new ResponseEntity<>(leaderboard, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Player> login(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		Player player = playerService.getPlayerByUsername(username);

		if (player != null && player.getPassword().equals(password))
			return new ResponseEntity<>(player, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/change-password")
	public ResponseEntity<Player> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {

		Player player = playerService.changePassword(changePasswordRequest.getPlayerId(),
				changePasswordRequest.getOldPassword(), changePasswordRequest.getNewPassword());

		if (player != null)
			return new ResponseEntity<>(player, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
