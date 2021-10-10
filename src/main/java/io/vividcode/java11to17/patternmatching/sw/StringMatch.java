package io.vividcode.java11to17.patternmatching.sw;

/**
 * Pattern guards
 */
public class StringMatch {

  public void test(Object obj) {
    switch (obj) {
      case String s && s.length() > 10 -> System.out.println(
          "long string -> " + s);
      case String s -> System.out.println("short string -> " + s);
      default -> System.out.println("others");
    }
  }
}
