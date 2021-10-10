package io.vividcode.java11to17.filter;

import java.io.ObjectInputFilter;
import java.util.function.BinaryOperator;

public class SampleFilterFactory implements BinaryOperator<ObjectInputFilter> {

  @Override
  public ObjectInputFilter apply(ObjectInputFilter current,
      ObjectInputFilter next) {
    if (current == null) {
      return next;
    } else {
      if (next != null) {
        next = ObjectInputFilter.merge(next, current);
        next = ObjectInputFilter.rejectUndecidedClass(next);
        return next;
      }
      return current;
    }
  }
}
