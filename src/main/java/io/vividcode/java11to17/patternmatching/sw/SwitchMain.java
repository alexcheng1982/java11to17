package io.vividcode.java11to17.patternmatching.sw;

public class SwitchMain {

  public static void main(String[] args) {
    StringMatch stringMatch = new StringMatch();
    stringMatch.test("hello world");
    stringMatch.test("hello");
    stringMatch.test(123);
  }
}
