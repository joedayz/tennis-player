package pe.joedayz.tennis_player.dao;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.joedayz.tennis_player.model.Player;

/**
 * @author josediaz
 **/
@Repository
public class PlayerDao {

  private static final class PlayerMapper implements RowMapper<Player> {
    public Player mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
      Player player = new Player();
      player.setId(rs.getInt("ID"));
      player.setName(rs.getString("NAME"));
      player.setNationality(rs.getString("NATIONALITY"));
      player.setBirthDate(rs.getDate("BIRTH_DATE"));
      player.setTitles(rs.getInt("TITLES"));
      return player;
    }
  }

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Player> getPlayerByNationality(String nationality) {
    String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
    return jdbcTemplate.query(sql, new PlayerMapper(), new Object[]{nationality});
  }


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
        player.getName(), player.getNationality(), new Timestamp(player.getBirthDate().getTime()),
        player.getTitles()});
  }

  public int updatePlayer(Player player) {
    String sql = "UPDATE PLAYER " +
        "SET NAME = ?, NATIONALITY = ?, BIRTH_DATE = ?, TITLES = ? " +
        "WHERE ID = ?";
    return jdbcTemplate.update(sql, new Object[]{player.getName(), player.getNationality(),
        new Timestamp(player.getBirthDate().getTime()), player.getTitles(), player.getId()});
  }

  public int deletePlayer(int id) {
    String sql = "DELETE FROM PLAYER WHERE ID = ?";
    return jdbcTemplate.update(sql, new Object[]{id});
  }


  public void createTournamentTable() {
    String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
    jdbcTemplate.execute(sql);
  }

}
