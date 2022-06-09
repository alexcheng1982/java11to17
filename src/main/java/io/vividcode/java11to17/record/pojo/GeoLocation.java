package io.vividcode.java11to17.record.pojo;

import java.util.Objects;

/** POJO version of value objects */
public class GeoLocation {

  private final double lng;
  private final double lat;

  public GeoLocation(double lng, double lat) {
    this.lat = lat;
    this.lng = lng;
  }

  public double getLng() {
    return this.lng;
  }

  public double getLat() {
    return this.lat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    GeoLocation that = (GeoLocation) o;
    return Double.compare(that.lng, this.lng) == 0 && Double.compare(that.lat, this.lat) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.lng, this.lat);
  }

  @Override
  public String toString() {
    return "GeoLocation{" + "lng=" + this.lng + ", lat=" + this.lat + '}';
  }
}
