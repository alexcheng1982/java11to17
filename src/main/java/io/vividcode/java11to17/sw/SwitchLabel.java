package io.vividcode.java11to17.sw;

public class SwitchLabel {

  enum TrafficColor {
    RED, YELLOW, GREEN
  }

  public void test(TrafficColor color) {
    switch (color) {
      case RED -> System.out.println("Stop!");
      case YELLOW -> System.out.println("Be careful!");
      case GREEN -> System.out.println("Go!");
    }
  }
}
