package io.vividcode.java11to17.jfr;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import jdk.jfr.consumer.RecordingStream;

public class JFRStreamingAsync {

  private static final ScheduledExecutorService
      executor = Executors.newSingleThreadScheduledExecutor();

  public void monitorCPU() {
    RecordingStream stream = new RecordingStream();
    stream.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
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
    stream.startAsync();
    executor.schedule(() -> {
          stream.close();
          try {
            stream.awaitTermination();
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            executor.shutdown();
          }
        }, 10,
        TimeUnit.SECONDS);
  }
}
