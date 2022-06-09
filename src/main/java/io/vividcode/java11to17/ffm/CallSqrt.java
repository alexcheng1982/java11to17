package io.vividcode.java11to17.ffm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;

public class CallSqrt {

  public double sqrt(double v) throws Throwable {
    MethodHandle sqrt =
        CLinker.getInstance()
            .downcallHandle(
                CLinker.systemLookup().lookup("sqrt").get(),
                MethodType.methodType(double.class, double.class),
                FunctionDescriptor.of(CLinker.C_DOUBLE, CLinker.C_DOUBLE));
    return (double) sqrt.invokeExact(v);
  }
}
