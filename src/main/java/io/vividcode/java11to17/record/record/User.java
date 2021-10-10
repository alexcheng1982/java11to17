package io.vividcode.java11to17.record.record;

/**
 * Variable arity record component
 */
public record User(String username, String... roles) {

}
