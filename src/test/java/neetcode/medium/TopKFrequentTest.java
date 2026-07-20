package neetcode.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shared.PerformanceMeter;

public class TopKFrequentTest extends PerformanceMeter<int[]> {

  TopKFrequent object = new TopKFrequent();

  @Test
  public void happyPath() {
    int[] ints = {1, 1, 2, 2, 3, 3, 3};
    int k = 2;

    int[] result = object.topKFrequent(ints, k);

    // 1. Проверяем размер
    Assertions.assertEquals(k, result.length);

    // 2. Переводим в Set/List для удобной проверки
    Set<Integer> resultSet = Arrays.stream(result).boxed().collect(Collectors.toSet());

    // 3. Самый частый элемент (3) обязан быть в ответе
    Assertions.assertTrue(resultSet.contains(3));

    // 4. Вторым элементом может быть либо 1, либо 2
    Assertions.assertTrue(resultSet.contains(1) || resultSet.contains(2));
  }

  @Override
  public int[] executeTestCase() {
    int[] ints = {1,1,2,2,3,3,3};
    int k = 2;

    return object.topKFrequent(ints, k);
  }
}
