package io.vividcode.java11to17.lib;

import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;

public class RandomAlgorithms {

  public static void main(String[] args) {
    String algorithms = RandomGeneratorFactory.all()
        .map(RandomGeneratorFactory::name).collect(
            Collectors.joining("\n"));
    System.out.println(algorithms);
    new GenerateRandoms().generate();
  }
}
