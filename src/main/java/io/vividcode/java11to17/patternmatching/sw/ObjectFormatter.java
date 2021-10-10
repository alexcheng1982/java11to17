package io.vividcode.java11to17.patternmatching.sw;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Pattern matching for switch expression
 */
public class ObjectFormatter {

  public String format(Object input) {
    return switch (input) {
      case null -> "";
      case Number n -> NumberFormat.getNumberInstance().format(n);
      case LocalDateTime t -> t.format(DateTimeFormatter.ISO_DATE_TIME);
      default -> input.toString();
    };
  }
}
