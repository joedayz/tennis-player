package pe.joedayz.tennis_player;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.joedayz.tennis_player.dao.PlayerDao;
import pe.joedayz.tennis_player.model.Player;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		logger.info("Inserting Play 4 -> {}", dao.insertPlayer(new Player(4, "Roger Federer",
				"Switzerland", new Date(System.currentTimeMillis()), 20)));

		logger.info("All Players Data -> {}", dao.getAllPlayers());

		logger.info("Player with Id 3 -> {}", dao.getPlayerById(3));
	}
}
