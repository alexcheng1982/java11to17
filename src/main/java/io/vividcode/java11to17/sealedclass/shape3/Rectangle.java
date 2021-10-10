package io.vividcode.java11to17.sealedclass.shape3;

public sealed class Rectangle extends Shape {

  final class Square extends Rectangle {

  }
}
