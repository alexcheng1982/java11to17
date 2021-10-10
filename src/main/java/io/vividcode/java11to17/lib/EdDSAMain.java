package io.vividcode.java11to17.lib;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;

public class EdDSAMain {

  public static void main(String[] args)
      throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
    System.out.println(Arrays.toString(new EdDSA().sign("hello")));
  }
}
