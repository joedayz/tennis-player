package pe.joedayz.tennis_player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.joedayz.tennis_player.repository.PlayerRepository;

/**
 * @author josediaz
 **/
@Service
public class PlayerService {

  @Autowired
  private PlayerRepository repo;
}
