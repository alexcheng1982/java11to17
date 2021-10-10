package io.vividcode.java11to17.textblock;

public class EscapeStrings {

  private static final String block = """
      ""\"""\""
      """;

  public static void main(String[] args) {
    System.out.println(block);
  }
}
