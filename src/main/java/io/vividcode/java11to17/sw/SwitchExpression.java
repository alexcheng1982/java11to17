package io.vividcode.java11to17.sw;

public class SwitchExpression {

  public String formatGifts(int number) {
    return switch (number) {
      case 0 -> "no gifts";
      case 1 -> "only one gift";
      default -> number + " gifts";
    };
  }
}
