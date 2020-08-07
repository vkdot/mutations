package com.vkdot.mutations.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public class ThreadComponentTest {

  @Test
  public void run() throws InterruptedException {
    List<String> logger = Collections.synchronizedList(new ArrayList<>());
    AtomicBoolean interrupted = new AtomicBoolean();

    Thread t = new Thread(() -> {
      new ThreadComponent(logger::add).run();
      interrupted.set(Thread.currentThread().isInterrupted());
    });
    t.start();
    t.interrupt();
    t.join();

    assertEquals(true, interrupted.get());
    assertEquals(1, logger.size());
    assertEquals("interrupted", logger.get(0));
  }

}
