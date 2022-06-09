package io.vividcode.java11to17.jvm;

public class NPE {

  private static class A {

    void doSomething() {}
  }

  private static class B {

    A a;
  }

  public static void main(String[] args) {
    B b = new B();
    b.a.doSomething();
  }
}
