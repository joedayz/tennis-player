package pe.joedayz.tennis_player.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.joedayz.tennis_player.model.Player;
import pe.joedayz.tennis_player.repository.PlayerSpringDataRepository;

/**
 * @author josediaz
 **/
@Service
public class PlayerService {

  @Autowired
  private PlayerSpringDataRepository repo;

  public List<Player> getAllPlayers(){
    return repo.findAll();
  }
}
