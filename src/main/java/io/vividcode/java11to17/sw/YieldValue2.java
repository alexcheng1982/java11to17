package io.vividcode.java11to17.sw;

public class YieldValue2 {

  public String formatGifts(int number) {
    return switch (number) {
      case 0:
        yield "no gifts";
      case 1:
        yield "only one gift";
      default: {
        if (number < 0) {
          yield "no gifts";
        } else {
          yield number + " gifts";
        }
      }
    };
  }
}
