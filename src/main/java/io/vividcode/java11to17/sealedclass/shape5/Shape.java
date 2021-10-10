package io.vividcode.java11to17.sealedclass.shape5;

/**
 * Sealed interface
 */
public sealed interface Shape {

  record Point(double x, double y) {

  }

  record Circle(Point center, double radius) implements Shape {

  }

  record Rectangle(Point topLeft, double width, double height) implements
      Shape {

  }
}
