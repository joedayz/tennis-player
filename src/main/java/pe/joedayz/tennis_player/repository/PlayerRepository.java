package pe.joedayz.tennis_player.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.tennis_player.model.Player;


/**
 @author josediaz   
 **/
@Repository
@Transactional
public class PlayerRepository {

  @PersistenceContext
  EntityManager entityManager;

  public Player insertPlayer(Player player) {
    return entityManager.merge(player);
  }

  public Player updatePlayer(Player player) {
    return entityManager.merge(player);
  }

  public Player getPlayerById(int id) {
    return entityManager.find(Player.class, id);
  }

  public void deletePlayerById(int id) {
    Player player = entityManager.find(Player.class, id);
    entityManager.remove(player);
  }

  public List<Player> getAllPlayers(){
    return entityManager.createNamedQuery("get_all_players", Player.class).getResultList();
  }
}
