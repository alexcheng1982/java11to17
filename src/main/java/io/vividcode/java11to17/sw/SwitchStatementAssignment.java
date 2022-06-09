package io.vividcode.java11to17.sw;

public class SwitchStatementAssignment {

  enum TrafficColor {
    RED,
    YELLOW,
    GREEN
  }

  public String getMessage(TrafficColor color) {
    String message;
    switch (color) {
      case RED:
        message = "Stop!";
        break;
      case GREEN:
        message = "Go!";
        break;
      default:
        message = "Be careful!";
    }
    return message;
  }
}
