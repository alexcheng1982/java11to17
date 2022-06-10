package io.vividcode.java11to17.hidden;


import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;

public class UseHiddenClass {

  public void useHiddenClass()
      throws IllegalAccessException, NoSuchMethodException,
      InvocationTargetException, InstantiationException {
    Class<?> clazz = MethodHandles.lookup()
        .defineHiddenClass(ClassGenerator.generate(), true)
        .lookupClass();
    System.out.println(clazz.getName());
    Object instance = clazz.getConstructor().newInstance();
    Object result = clazz.getMethod("sayHi").invoke(instance);
    System.out.println(result);
  }
}
