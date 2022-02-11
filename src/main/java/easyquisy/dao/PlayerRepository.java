package easyquisy.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import easyquisy.domain.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

	Optional<Player> findByUsername(String username);

}
