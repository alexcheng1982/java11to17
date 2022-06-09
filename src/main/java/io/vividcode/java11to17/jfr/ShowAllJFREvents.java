package io.vividcode.java11to17.jfr;

import jdk.jfr.FlightRecorder;

public class ShowAllJFREvents {

  public static void main(String[] args) {
    System.out.println(FlightRecorder.getFlightRecorder().getEventTypes().size());
    FlightRecorder.getFlightRecorder()
        .getEventTypes()
        .forEach(eventType -> System.out.println(eventType.getName()));
  }
}
