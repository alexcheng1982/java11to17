package io.vividcode.java11to17.sw;

public class SwitchStatement {

  enum TrafficColor {
    RED,
    YELLOW,
    GREEN
  }

  public void trafficControl(TrafficColor color) {
    switch (color) {
      case RED:
        this.stop();
      case GREEN:
        this.go();
      default:
        this.watchOut();
    }
  }

  private void go() {
    System.out.println("Go!");
  }

  private void stop() {
    System.out.println("Stop!");
  }

  private void watchOut() {
    System.out.println("Be careful!");
  }
}
