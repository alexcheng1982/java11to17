package io.vividcode.java11to17.jvmconstants;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.MethodTypeDesc;

public class UseConstants {

  public void describe() {
    MethodTypeDesc desc = MethodTypeDesc.of(
        ConstantDescs.CD_void,
        ClassDesc.of("java.lang.String")
    );
    System.out.println(desc.descriptorString()); // (Ljava/lang/String;)V
  }
}