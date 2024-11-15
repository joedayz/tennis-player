package pe.joedayz.tennis_player.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author josediaz
 **/
@RestController
public class PlayerController {

  @GetMapping("/welcome")
  public String welcome(){
    return "Welcome to the Tennis Player API";
  }
}
