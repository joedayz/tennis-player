package pe.joedayz.tennis_player.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.tennis_player.model.Player;
import pe.joedayz.tennis_player.service.PlayerService;

/**
 * @author josediaz
 **/
@RestController
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  @GetMapping("/players")
  //@RequestMapping("/players", method = RequestMethod.GET)
  public List<Player> getAllPlayers(){
    return playerService.getAllPlayers();
  }

  @GetMapping("/players/{id}")
  public Player getPlayerById(@PathVariable int id){
    return playerService.getPlayerById(id);
  }

  @PostMapping("/players")
  public Player insertPlayer(@RequestBody Player player){
    return playerService.insertPlayer(player);
  }

@PutMapping("/players/{id}")
  public Player updatePlayer(@PathVariable int id, @RequestBody Player player){
    return playerService.updatePlayer(id, player);
  }

  @PatchMapping("/players/{id}")
  public Player patch(@PathVariable int id, @RequestBody Map<String, Object> playerPatch){
    return playerService.patch(id, playerPatch);
  }

  @PatchMapping("/players/{id}/titles")
  public void updateTitles(@PathVariable int id, @RequestBody int titles){
    playerService.updateTitles(id, titles);
  }

  @DeleteMapping("/players/{id}")
  public void deletePlayerById(@PathVariable int id){
    playerService.deletePlayer(id);
  }

}
