package io.vividcode.java11to17.sw;

import io.vividcode.java11to17.sw.SwitchLabel.TrafficColor;

public class SwitchMain {

  public static void main(String[] args) {
    SwitchLabel switchLabel = new SwitchLabel();
    switchLabel.test(TrafficColor.RED);
    SwitchStatement switchStatement = new SwitchStatement();
    switchStatement.trafficControl(SwitchStatement.TrafficColor.RED);
  }
}
