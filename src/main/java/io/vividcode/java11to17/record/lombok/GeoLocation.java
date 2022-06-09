package io.vividcode.java11to17.record.lombok;

import lombok.Value;

/** Lombok version of value objects */
@Value
public class GeoLocation {

  double lng;
  double lat;
}
