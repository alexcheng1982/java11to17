package io.vividcode.java11to17.lib;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

public class EdDSA {

  public byte[] sign(String input)
      throws InvalidKeyException, NoSuchAlgorithmException, SignatureException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("Ed25519");
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    Signature signature = Signature.getInstance("Ed25519");
    signature.initSign(keyPair.getPrivate());
    signature.update(input.getBytes(StandardCharsets.UTF_8));
    return signature.sign();
  }
}
