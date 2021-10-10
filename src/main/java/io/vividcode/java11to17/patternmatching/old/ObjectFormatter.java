package io.vividcode.java11to17.patternmatching.old;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Old way of using instanceof
 */
public class ObjectFormatter {

  public String format(Object input) {
    if (input == null) {
      return "";
    } else if (input instanceof Number) {
      return NumberFormat.getNumberInstance().format(input);
    } else if (input instanceof LocalDateTime) {
      return ((LocalDateTime) input).format(DateTimeFormatter.ISO_DATE_TIME);
    } else {
      return input.toString();
    }
  }
}
