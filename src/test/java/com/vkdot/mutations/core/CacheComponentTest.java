package com.vkdot.mutations.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.powermock.reflect.Whitebox;

@RunWith(BlockJUnit4ClassRunner.class)
public class CacheComponentTest {

  private CacheComponent cache;

  @Before
  public void setUp() {
    cache = new CacheComponent();
  }

  @Test
  public void isExpiredNoEntry() {
    assertEquals(true, cache.isExpired("test"));
  }

  @Test
  public void isExpiredOld() {
    cache.add("test", "value", LocalDateTime.now().minusDays(1));
    assertEquals(true, cache.isExpired("test"));
  }

  @Test
  public void isExpiredNew() {
    cache.add("test", "value", LocalDateTime.now().plusDays(1));
    assertEquals(false, cache.isExpired("test"));
  }

  @Test
  public void isExpiredNoData() {
    cache.add("test", "value", LocalDateTime.now().plusDays(1));
    Map<String, String> data = Whitebox.getInternalState(cache, "data");
    data.remove("test");

    assertEquals(true, cache.isExpired("test"));
  }

  @Test
  public void isExpiredNoTime() {
    cache.add("test", "value", LocalDateTime.now().plusDays(1));
    Map<String, LocalDateTime> expiryDates = Whitebox.getInternalState(cache, "expiryDates");
    expiryDates.remove("test");

    assertEquals(true, cache.isExpired("test"));
  }
}
