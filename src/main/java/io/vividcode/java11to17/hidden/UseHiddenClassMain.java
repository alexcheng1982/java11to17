package io.vividcode.java11to17.hidden;

import java.lang.reflect.InvocationTargetException;

public class UseHiddenClassMain {

  public static void main(String[] args)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
    new UseHiddenClass().useHiddenClass();
  }
}
