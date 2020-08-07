package com.vkdot.mutations.core;

import java.util.function.Consumer;

public class ThreadComponent implements Runnable {

  private final Consumer<String> logger;

  public ThreadComponent(Consumer<String> logger) {
    this.logger = logger;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      logger.accept("interrupted");
      Thread.currentThread().interrupt();
    }
  }
}
