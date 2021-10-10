package io.vividcode.java11to17.record.record;

import io.vividcode.java11to17.record.record.Order.Address;
import io.vividcode.java11to17.record.record.Order.LineItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OrderCalculatorMain {

  public static void main(String[] args) {
    Order order1 = new Order("o001", "u001", LocalDateTime.now(), List.of(
        new LineItem("p001", 2, BigDecimal.valueOf(100.0))
    ), new Address("A1", "C1", "P1", "000"));
    Order order2 = new Order("o002", "u001", LocalDateTime.now(), List.of(
        new LineItem("p002", 3, BigDecimal.valueOf(50.0))
    ), new Address("A1", "C1", "P1", "000"));
    Order order3 = new Order("o003", "u002", LocalDateTime.now(), List.of(
        new LineItem("p003", 2, BigDecimal.valueOf(400.0))
    ), new Address("A1", "C1", "P1", "000"));
    OrderCalculator calculator = new OrderCalculator();
    Map<String, OrderSummary> result = calculator.calculate(
        List.of(order1, order2, order3));
    System.out.println(result);
  }
}
