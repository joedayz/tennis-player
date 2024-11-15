package pe.joedayz.tennis_player.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.tennis_player.model.Player;

/**
 * @author josediaz
 **/
@Repository
@Transactional
public class PlayerRepository {

  @PersistenceContext
  EntityManager entityManager;

  public Player insertPlayer(Player player){
    return entityManager.merge(player);
  }

  public Player updatePlayer(Player player){
    return entityManager.merge(player);
  }
}
