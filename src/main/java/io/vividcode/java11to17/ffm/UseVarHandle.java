package io.vividcode.java11to17.ffm;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.util.Arrays;
import jdk.incubator.foreign.MemoryHandles;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

public class UseVarHandle {

  public void access() {
    MemorySegment segment = MemorySegment.allocateNative(20,
        ResourceScope.newImplicitScope());
    VarHandle varHandle = MemoryHandles.varHandle(int.class,
        ByteOrder.nativeOrder());
    for (int i = 0; i < 5; i++) {
      varHandle.set(segment, i * 4, i * 100);
    }
    int[] values = segment.toIntArray();
    System.out.println(Arrays.toString(values)); // [0, 100, 200, 300, 400]
  }
}
