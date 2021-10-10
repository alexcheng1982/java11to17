package io.vividcode.java11to17.record.record2;

public record GeoLocation(double lng, double lat) {

  public GeoLocation(double lng, double lat) {
    if (lng <= 180 && lng >= -180) {
      this.lng = lng;
    } else {
      throw new IllegalArgumentException("Invalid value of longitude");
    }
    if (lat <= 90 && lat >= -90) {
      this.lat = lat;
    } else {
      throw new IllegalArgumentException("Invalid value of latitude");
    }
  }
}
