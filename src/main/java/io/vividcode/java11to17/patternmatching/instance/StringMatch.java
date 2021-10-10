package io.vividcode.java11to17.patternmatching.instance;

/**
 * Pattern matching for instanceof
 */
public class StringMatch {

  public void test(Object obj) {
    if (obj instanceof String s && s.length() > 10) {
      System.out.println("long string -> " + s);
    } else if (obj instanceof String s) {
      System.out.println("short string -> " + s);
    } else {
      System.out.println("others");
    }
  }
}
