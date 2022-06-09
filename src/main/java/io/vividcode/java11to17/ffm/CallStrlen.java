package io.vividcode.java11to17.ffm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

public class CallStrlen {

  public long strlen(String input) throws Throwable {
    MethodHandle strlen =
        CLinker.getInstance()
            .downcallHandle(
                CLinker.systemLookup().lookup("strlen").get(),
                MethodType.methodType(int.class, MemoryAddress.class),
                FunctionDescriptor.of(CLinker.C_INT, CLinker.C_POINTER));
    MemorySegment cStr = CLinker.toCString(input, ResourceScope.newImplicitScope());
    return (int) strlen.invokeExact(cStr.address());
  }
}
