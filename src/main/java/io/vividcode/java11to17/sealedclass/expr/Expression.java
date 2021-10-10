package io.vividcode.java11to17.sealedclass.expr;

/**
 * Sealed interface
 */
public sealed interface Expression permits ConstantExpr, DynamicExpr {

}
