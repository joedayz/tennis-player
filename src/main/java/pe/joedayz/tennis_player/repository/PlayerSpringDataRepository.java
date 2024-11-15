package pe.joedayz.tennis_player.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.joedayz.tennis_player.model.Player;

/**
 * @author josediaz
 **/
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {

    public List<Player> findByNationality(String nationality);
}
