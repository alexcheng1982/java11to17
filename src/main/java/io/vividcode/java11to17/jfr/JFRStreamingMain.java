package io.vividcode.java11to17.jfr;

import java.util.concurrent.ExecutionException;

public class JFRStreamingMain {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    //    new JFRStreaming().monitorCPU();
    new JFRStreamingAsync().monitorCPU();
  }
}
