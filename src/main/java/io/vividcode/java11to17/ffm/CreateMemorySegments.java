package io.vividcode.java11to17.ffm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

public class CreateMemorySegments {

  public void create() throws IOException {
    MemorySegment.allocateNative(1024, ResourceScope.newImplicitScope());
    MemorySegment.ofArray(new int[]{1, 2, 3, 4});
    MemorySegment.ofByteBuffer(ByteBuffer.allocate(64));
    MemorySegment.mapFile(Paths.get("test"), 0, 1024, MapMode.READ_ONLY,
        ResourceScope.newImplicitScope());
  }
}
