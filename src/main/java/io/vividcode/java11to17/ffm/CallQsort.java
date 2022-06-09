package io.vividcode.java11to17.ffm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayouts;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

public class CallQsort {

  public int[] qsort(int[] array) throws Throwable {
    MethodHandle qsort =
        CLinker.getInstance()
            .downcallHandle(
                CLinker.systemLookup().lookup("qsort").get(),
                MethodType.methodType(
                    void.class, MemoryAddress.class, int.class, int.class, MemoryAddress.class),
                FunctionDescriptor.ofVoid(
                    CLinker.C_POINTER, CLinker.C_INT, CLinker.C_INT, CLinker.C_POINTER));
    MethodHandle compare =
        MethodHandles.lookup()
            .findStatic(
                CallQsort.class,
                "compare",
                MethodType.methodType(int.class, MemoryAddress.class, MemoryAddress.class));
    MemoryAddress compareFuncPointer =
        CLinker.getInstance()
            .upcallStub(
                compare,
                FunctionDescriptor.of(CLinker.C_INT, CLinker.C_POINTER, CLinker.C_POINTER),
                ResourceScope.newImplicitScope());
    MemorySegment nativeArray =
        MemorySegment.allocateNative(
            MemoryLayouts.JAVA_INT.byteSize() * array.length, ResourceScope.newImplicitScope());
    nativeArray.copyFrom(MemorySegment.ofArray(array));
    qsort.invokeExact(
        nativeArray.address(),
        array.length,
        (int) MemoryLayouts.JAVA_INT.byteSize(),
        compareFuncPointer);
    return nativeArray.toIntArray();
  }

  public static int compare(MemoryAddress address1, MemoryAddress address2) {
    return MemoryAccess.getIntAtOffset(
            MemorySegment.globalNativeSegment(), address1.toRawLongValue())
        - MemoryAccess.getIntAtOffset(
            MemorySegment.globalNativeSegment(), address2.toRawLongValue());
  }
}
