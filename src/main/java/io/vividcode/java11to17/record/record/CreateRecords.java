package io.vividcode.java11to17.record.record;

import java.math.BigDecimal;
import java.util.Arrays;

public class CreateRecords {

  public static void main(String[] args) {
    System.out.println(new GeoLocation(0.0, 0.0));
    User user = new User("alex", "admin", "ops");
    System.out.println(Arrays.toString(user.roles()));
    System.out.println(new GeoLocation(100.0, 30));
    Book book = new Book("001", "t", "d", BigDecimal.valueOf(20));
    System.out.println(book);
    System.out.println(new Book(null, null, null, null));
  }
}
