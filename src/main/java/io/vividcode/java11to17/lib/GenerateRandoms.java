package io.vividcode.java11to17.lib;

import java.util.random.RandomGenerator;

public class GenerateRandoms {

  public void generate() {
    RandomGenerator.getDefault().ints(10).forEach(System.out::println);
  }
}
