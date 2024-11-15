package pe.joedayz.tennis_player.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.tennis_player.model.Player;
import pe.joedayz.tennis_player.service.PlayerService;

/**
 * @author josediaz
 **/
@RestController
public class PlayerController {

  @Autowired
  PlayerService service;

  @GetMapping("/welcome")
  public String welcome(){
    return "Welcome to the Tennis Player API";
  }

  @GetMapping("/players")
  public List<Player> getPlayers(){
    return service.getAllPlayers();
  }
}
