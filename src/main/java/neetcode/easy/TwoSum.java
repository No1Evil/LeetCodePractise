package neetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    if (nums.length < 2 || nums.length > 1000) {
      throw new IllegalArgumentException();
    }

    Map<Integer, Integer> differenceMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++){
      int difference = target - nums[i]; // 7 = 10 - 3

      Integer storedIndex = differenceMap.get(difference);

      if (storedIndex != null) {
        if (i > storedIndex) {
          return new int[]{storedIndex, i};
        } else {
          return new int[]{i, storedIndex};
        }
      }

      differenceMap.put(nums[i], i);
    }

    throw new RuntimeException();
  }

}
