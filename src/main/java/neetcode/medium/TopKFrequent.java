package neetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

  public int[] topKFrequent(int[] nums, int k) {

    // Number X frequency
    Map<Integer, Integer> frequencyMap = new HashMap<>(nums.length);

    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    List<List<Integer>> buckets = new ArrayList<>();

    for (int i = 0; i <= nums.length; i++) {
      buckets.add(new ArrayList<>());
    }

    for (var entry : frequencyMap.entrySet()) {
      List<Integer> nodes = buckets.get(entry.getValue());
      nodes.add(entry.getKey());
    }

    int[] answer = new int[k];

    int counter = 0;
    for (int i = buckets.size() - 1; i >= 0; i--) {
      if (counter == k) break;

      List<Integer> nodes = buckets.get(i);
      for (Integer value : nodes) {
        if (counter == k) break;
        answer[counter] = value;
        counter++;
      }
    }

    return answer;
  }

}
