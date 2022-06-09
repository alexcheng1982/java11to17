package io.vividcode.java11to17.ffm;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemoryLayouts;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SequenceLayout;

public class PointStructure {

  private final MemoryLayout pointLayout =
      MemoryLayout.structLayout(
          MemoryLayouts.JAVA_INT.withName("x"), MemoryLayouts.JAVA_INT.withName("y"));
  private final SequenceLayout pointsLayout = MemoryLayout.sequenceLayout(this.pointLayout);
  private final VarHandle xHandle =
      this.pointsLayout.varHandle(
          int.class, PathElement.sequenceElement(), PathElement.groupElement("x"));
  private final VarHandle yHandle =
      this.pointsLayout.varHandle(
          int.class, PathElement.sequenceElement(), PathElement.groupElement("y"));

  public MemorySegment save(List<Point> points) {
    MemorySegment segment =
        MemorySegment.allocateNative(
            this.pointLayout.byteSize() * points.size(), ResourceScope.newImplicitScope());
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      this.xHandle.set(segment, (long) i, point.x());
      this.yHandle.set(segment, (long) i, point.y());
    }
    return segment;
  }

  public List<Point> load(MemorySegment segment) {
    int numberOfPoints = (int) (segment.byteSize() / this.pointLayout.byteSize());
    List<Point> points = new ArrayList<>(numberOfPoints);
    for (int i = 0; i < numberOfPoints; i++) {
      int x = (int) this.xHandle.get(segment, (long) i);
      int y = (int) this.yHandle.get(segment, (long) i);
      points.add(new Point(x, y));
    }
    return points;
  }
}
