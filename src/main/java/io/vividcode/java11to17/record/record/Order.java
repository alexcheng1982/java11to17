package io.vividcode.java11to17.record.record;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Nested records
 */
public record Order(String orderId, String userId, LocalDateTime createdAt,
                    List<LineItem> lineItems,
                    Address deliveryAddress) {

  public record LineItem(String productId, int quantity, BigDecimal price) {

  }

  public record Address(String addressLine, String cityId, String provinceId,
                        String zipCode) {

  }
}
