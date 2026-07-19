package shared;

import org.junit.jupiter.api.Test;

public abstract class PerformanceMeter<V> {

  public abstract V executeTestCase();

  @Test
  public void testAveragePerformance(){
    int iterations = 10_000;

    V sink = null;

    for (int i = 0; i < iterations; i++) {
      sink = executeTestCase();
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < iterations; i++) {
      sink = executeTestCase();
    }

    long endTime = System.nanoTime();

    long averageTime = (endTime - startTime) / iterations;
    System.out.println("Average execution time is " + averageTime + "ns");
    System.out.println("Last result: " + sink);
  }
}
