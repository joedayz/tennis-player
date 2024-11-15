package pe.joedayz.tennis_player.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.joedayz.tennis_player.model.Player;

/**
 * @author josediaz
 **/
@Repository
public class PlayerDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Player> getAllPlayers(){
    String sql = "SELECT * FROM PLAYER";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));

  }
}
