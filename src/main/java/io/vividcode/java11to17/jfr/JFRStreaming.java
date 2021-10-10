package io.vividcode.java11to17.jfr;

import java.time.Instant;
import jdk.jfr.consumer.EventStream;
import jdk.jfr.consumer.RecordingStream;

public class JFRStreaming {

  public void monitorCPU() {
    try (EventStream stream = new RecordingStream()) {
      stream.setEndTime(Instant.now().plusSeconds(10));
      stream.onEvent("jdk.CPULoad", event -> {
        String info = """
            startTime: %s
            machineTotal: %s
            jvmSystem: %s
            jvmUser %s
            """.formatted(
            event.getStartTime(),
            event.getFloat("machineTotal"),
            event.getFloat("jvmSystem"),
            event.getFloat("jvmUser"));
        System.out.println(info);
      });
      stream.start();
    }
  }

}
