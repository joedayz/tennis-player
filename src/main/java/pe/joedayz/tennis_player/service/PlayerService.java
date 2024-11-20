package pe.joedayz.tennis_player.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import pe.joedayz.tennis_player.exception.PlayerNotFoundException;
import pe.joedayz.tennis_player.model.Player;
import pe.joedayz.tennis_player.repository.PlayerSpringDataRepository;

/**
 * @author josediaz
 **/
@Service
public class PlayerService {

  @Autowired
  private PlayerSpringDataRepository repository;

  public List<Player> getAllPlayers() {
    return repository.findAll();
  }

  public Player getPlayerById(int id) {


    Optional<Player> tempPlayer  = repository.findById(id);
    Player p = null;

    if(tempPlayer.isPresent()) {
      p = tempPlayer.get();
    }else {
      throw new PlayerNotFoundException("Player with id " + id + " not found");
    }

    return p;
  }

  public Player insertPlayer(Player player) {
    return repository.save(player);
  }

  public Player updatePlayer(int id, Player p) {
    //get player object by Id
    Optional<Player> tempPlayer = repository.findById(id);

    Player player = null;

    //if the Optional has a value, assign it to p
    if(tempPlayer.isPresent())
      player = tempPlayer.get();
    else
      throw new PlayerNotFoundException("Player with id "+ id + " not found.");

    //update player information in database
    player.setName(p.getName());
    player.setNationality(p.getNationality());
    player.setBirthDate(p.getBirthDate());
    player.setTitles(p.getTitles());

    //save updates
    return repository.save(player);
  }

  public Player patch(int id, Map<String, Object> playerPatch) {
    Optional<Player> player = repository.findById(id);
    if (player.isPresent()) {
      playerPatch.forEach((key, value) -> {
        Field field = ReflectionUtils.findField(Player.class, key);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, player.get(), value);
      });
    }

    return repository.save(player.get());

  }

  @Transactional
  public void updateTitles(int id, int titles){
    repository.updateTitles(id, titles);
  }
  //delete a player
  public String deletePlayer(int id) {
    Optional<Player> tempPlayer = repository.findById(id);

    if(tempPlayer.isEmpty()) {

      throw new PlayerNotFoundException("Player with id "+ id + " not found.");
    }

    repository.delete(tempPlayer.get());
    return "Player with id "+ id +" deleted";
  }
}
