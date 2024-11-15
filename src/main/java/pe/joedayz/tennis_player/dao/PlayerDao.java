package pe.joedayz.tennis_player.dao;

import java.sql.Timestamp;
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

  public Player getPlayerById(int id){
    String sql = "SELECT * FROM PLAYER WHERE ID = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Player>(Player.class));
  }

  public int insertPlayer(Player player) {
    String sql = "INSERT INTO PLAYER (ID, NAME, NATIONALITY, BIRTH_DATE, TITLES) VALUES(?, ?, ?, ?, ?)";

    return jdbcTemplate.update(sql, new Object[] {player.getId(),
        player.getName(), player.getNationality(), new Timestamp(player.getBitrhdate().getTime()),
        player.getTitles()});
  }


}
