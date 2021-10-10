package io.vividcode.java11to17.ffm;

import java.lang.invoke.VarHandle;
import java.util.stream.StreamSupport;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayouts;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SequenceLayout;

public class SharedScope {

  public void parallelProcessing() {
    SequenceLayout intsLayout = MemoryLayout.sequenceLayout(102400,
        MemoryLayouts.JAVA_INT);
    try (ResourceScope scope = ResourceScope.newSharedScope()) {
      MemorySegment segment = MemorySegment.allocateNative(intsLayout, scope);
      VarHandle varHandle = intsLayout.elementLayout().varHandle(int.class);
      for (int i = 0; i < intsLayout.elementCount().getAsLong(); i++) {
        MemoryAccess.setIntAtIndex(segment, i, i);
      }
      int sum = StreamSupport.stream(
              segment.spliterator(intsLayout.elementLayout()),
              true)
          .mapToInt(s -> (int) varHandle.get(s))
          .sum();
      System.out.println(sum);
    }
  }
}
