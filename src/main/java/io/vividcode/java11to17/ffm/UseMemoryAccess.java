package io.vividcode.java11to17.ffm;

import java.util.Arrays;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

public class UseMemoryAccess {

  public void access() {
    MemorySegment segment = MemorySegment.allocateNative(20,
        ResourceScope.newImplicitScope());
    for (int i = 0; i < 5; i++) {
      MemoryAccess.setIntAtIndex(segment, i, i * 100);
    }
    int[] values = segment.toIntArray();
    System.out.println(Arrays.toString(values)); // [0, 100, 200, 300, 400]
  }
}
