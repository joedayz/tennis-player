package pe.joedayz.tennis_player.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;
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

  public Player getPlayerById(int id){
    return entityManager.find(Player.class, id);
  }

  public List<Player> findPlayersByNationalityAndTitles(String nationality, int titles){
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    var cq = cb.createQuery(Player.class);
    var player = cq.from(Player.class);
    cq.select(player).where(cb.and(cb.equal(player.get("nationality"), nationality),
        cb.greaterThanOrEqualTo(player.get("titles"), titles)));
    return entityManager.createQuery(cq).getResultList();
  }

}
