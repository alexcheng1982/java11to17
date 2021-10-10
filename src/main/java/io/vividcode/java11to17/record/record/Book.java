package io.vividcode.java11to17.record.record;

import java.math.BigDecimal;

/**
 * Record with a compact constructor
 */
public record Book(String isbn, String title, String description,
                   BigDecimal price) {

  public Book {
    if (isbn == null) {
      throw new IllegalArgumentException("ISBN is invalid");
    }
  }
}
