package com.vkdot.mutations.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CacheComponent {

  private final Map<String, LocalDateTime> expiryDates;
  private final Map<String, String> data;

  public CacheComponent() {
    this.expiryDates = new HashMap<>();
    this.data = new HashMap<>();
  }

  public void add(String key, String value, LocalDateTime expiryDate) {
    data.put(key, value);
    expiryDates.put(key, expiryDate);
  }

  public boolean isExpired(String key) {
    if (data.containsKey(key) && expiryDates.containsKey(key)) {
      return expiryDates.get(key).isBefore(LocalDateTime.now());
    }
    return true;
  }
}
