package io.vividcode.java11to17.sealedclass.shape4;

public abstract sealed class Shape {

  final class Circle extends Shape {

  }

  sealed class Rectangle extends Shape {

    final class Square extends Rectangle {

    }
  }

  non-sealed class FreeFormShape extends Shape {

  }
}
