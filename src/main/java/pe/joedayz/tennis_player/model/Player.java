package pe.joedayz.tennis_player.model;

import java.util.Date;

/**
 * @author josediaz
 **/
public class Player {

  private int id;
  private String name;
  private String nationality;
  private Date bitrhdate;
  private int titles;

  public Player() {
  }

  public Player(int id, String name, String nationality, Date bitrhdate, int titles) {
    this.id = id;
    this.name = name;
    this.nationality = nationality;
    this.bitrhdate = bitrhdate;
    this.titles = titles;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Date getBitrhdate() {
    return bitrhdate;
  }

  public void setBitrhdate(Date bitrhdate) {
    this.bitrhdate = bitrhdate;
  }

  public int getTitles() {
    return titles;
  }

  public void setTitles(int titles) {
    this.titles = titles;
  }

  @Override
  public String toString() {
    return "Player{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", nationality='" + nationality + '\'' +
        ", bitrhdate=" + bitrhdate +
        ", titles=" + titles +
        '}';
  }
}
