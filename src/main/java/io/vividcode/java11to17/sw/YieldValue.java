package io.vividcode.java11to17.sw;

public class YieldValue {

  public String formatGifts(int number) {
    return switch (number) {
      case 0 -> "no gifts";
      case 1 -> "only one gift";
      default -> {
        if (number < 0) {
          yield "no gifts";
        } else {
          yield number + " gifts";
        }
      }
    };
  }
}
