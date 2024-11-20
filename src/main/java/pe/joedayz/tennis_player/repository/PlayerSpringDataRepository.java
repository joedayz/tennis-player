package pe.joedayz.tennis_player.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.joedayz.tennis_player.model.Player;

/**
 @author josediaz   
 **/
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {

   public List<Player> findByNationality(String nationality);

   @Modifying
   @Query("update Player p set p.titles = :titles where p.id = :id")
   void updateTitles(@Param("id") int id, @Param("titles") int titles);

}
