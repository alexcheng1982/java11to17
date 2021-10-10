package io.vividcode.java11to17.hidden;

import java.lang.reflect.Modifier;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class ClassGenerator {

  private final static ByteBuddy byteBuddy = new ByteBuddy();

  public static byte[] generate() {
    return byteBuddy.subclass(Object.class)
        .name("io.vividcode.java11to17.hidden.MyClass")
        .defineMethod("sayHi", String.class, Modifier.PUBLIC)
        .intercept(FixedValue.value("Hello"))
        .make()
        .getBytes();
  }
}
