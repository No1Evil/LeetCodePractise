package common.concurrency;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcurrentModificationExceptionTest {

  private final ArrayList<Object> arrayList = new ArrayList<>();
  private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

  @BeforeEach
  public void init() {
    arrayList.clear();
    arrayList.add("init");
  }

  @Test
  public void shouldThrowConcurrentModificationException() {

    Future<?> reader = executor.submit(() -> {
      AtomicLong counter = new AtomicLong(0L);
      while (!Thread.currentThread().isInterrupted()) {
        arrayList.forEach(_ -> {
          counter.getAndIncrement();
        });
      }
      System.out.println(counter.get()); // prevent ignoring the while block
    });

    Future<?> writer = executor.submit(() -> {
      while (!Thread.currentThread().isInterrupted()) {
        arrayList.add("obj");
        arrayList.removeFirst();
      }
    });

    ExecutionException exception = Assertions.assertThrows(ExecutionException.class, reader::get);

    writer.cancel(true);

    Throwable realException = exception.getCause();
    boolean isExpected = realException instanceof ConcurrentModificationException;

    Assertions.assertTrue(isExpected, "Thrown with unexpected exception: " + realException);
  }


}
