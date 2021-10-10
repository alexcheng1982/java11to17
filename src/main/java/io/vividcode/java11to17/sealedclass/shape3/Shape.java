package io.vividcode.java11to17.sealedclass.shape3;

/**
 * Sealed class with final, sealed, and non-sealed subclasses
 */
public abstract sealed class Shape permits Circle, Rectangle, FreeFormShape {

}
