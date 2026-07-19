package neetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import neetcode.easy.IsAnagram;

public class GroupAnagrams {

  IsAnagram util = new IsAnagram();

  //Input: strs = ["act","pots","tops","cat","stop","hat"]
  //Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length < 1 || strs.length > 1000) {
      throw new IllegalArgumentException();
    }

    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray);
      String key = new String(charArray);

      List<String> array = map.getOrDefault(key, new ArrayList<>());
      array.add(s);
      map.put(key, array);
    }

    return map.values().stream().toList();
  }

  public List<List<String>> groupAnagrams1(String[] strs) {
    if (strs.length < 1 || strs.length > 1000) {
      throw new IllegalArgumentException();
    }

    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      int[] count = new int[26];

      for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
      }

      String key = Arrays.toString(count);

      List<String> array = map.getOrDefault(key, new ArrayList<>());
      array.add(s);
      map.put(key, array);
    }

    return map.values().stream().toList();
  }

}
