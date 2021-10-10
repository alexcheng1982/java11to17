package io.vividcode.java11to17.record.record2;

import java.math.BigDecimal;

public record Book(String isbn, String title, String description,
                   BigDecimal price) {

  public Book(String isbn, String title, String description, BigDecimal price) {
    if (isbn == null) {
      throw new IllegalArgumentException("ISBN is invalid");
    }
    this.isbn = isbn;
    this.title = title;
    this.description = description;
    this.price = price;
  }
}
