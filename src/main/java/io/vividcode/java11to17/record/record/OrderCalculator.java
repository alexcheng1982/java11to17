package io.vividcode.java11to17.record.record;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Usage of local records
 */
public class OrderCalculator {

  public Map<String, OrderSummary> calculate(List<Order> orders) {
    record OrderTotal(String orderId, BigDecimal total) {

    }

    Map<String, List<OrderTotal>> orderTotal = orders.stream()
        .collect(
            Collectors.groupingBy(Order::userId, Collectors.mapping(order -> {
              BigDecimal total = order.lineItems().stream()
                  .map(item -> item.price()
                      .multiply(BigDecimal.valueOf(item.quantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
              return new OrderTotal(order.orderId(), total);
            }, Collectors.toList())));
    return orderTotal.entrySet().stream().map(entry ->
            new OrderSummary(entry.getKey(),
                entry.getValue().stream()
                    .max(Comparator.comparing(OrderTotal::total))
                    .map(OrderTotal::total).orElse(BigDecimal.ZERO)))
        .collect(Collectors.toMap(OrderSummary::userId, Function.identity()));
  }
}
