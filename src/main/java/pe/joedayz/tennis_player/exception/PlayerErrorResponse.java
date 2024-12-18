package pe.joedayz.tennis_player.exception;

import java.time.ZonedDateTime;

/**
 * @author josediaz
 **/
public class PlayerErrorResponse {
  private ZonedDateTime timestamp;
  private int statusCode;
  private String path;
  private String message;

  public PlayerErrorResponse(ZonedDateTime timestamp, int statusCode, String path, String message) {
    this.timestamp = timestamp;
    this.statusCode = statusCode;
    this.path = path;
    this.message = message;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
