package neetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shared.PerformanceMeter;

public class TwoSumTest extends PerformanceMeter<int[]> {

  TwoSum object = new TwoSum();

  @Test
  public void happyPath() {
    // nums = [3,4,5,6], target = 7
    int[] nums = new int[]{3,4,5,6};
    int target = 7;
    Assertions.assertArrayEquals(new int[]{0, 1}, object.twoSum(nums, target));
  }

  @Test
  public void endPath() {
    int[] nums = new int[]{3,3,3,3};
    int target = 7;
    Assertions.assertThrows(RuntimeException.class, () -> object.twoSum(nums, target));
  }

  @Override
  public int[] executeTestCase() {
    int[] nums = new int[]{3,4,5,6};
    int target = 7;
    return object.twoSum(nums, target);
  }
}
