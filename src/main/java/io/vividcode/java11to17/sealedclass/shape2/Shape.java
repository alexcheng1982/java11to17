package io.vividcode.java11to17.sealedclass.shape2;

/**
 * Sealed class and subclasses in one source file
 */
public abstract sealed class Shape {

  final class Circle extends Shape {

  }

  final class Rectangle extends Shape {

  }

  final class Triangle extends Shape {

  }
}
