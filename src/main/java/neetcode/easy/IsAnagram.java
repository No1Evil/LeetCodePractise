package neetcode.easy;

import java.util.Arrays;

public class IsAnagram {
  public boolean isAnagram(String s, String t) {
    char[] charArray = s.toCharArray();
    char[] charArray1 = t.toCharArray();
    Arrays.sort(charArray);
    Arrays.sort(charArray1);
    return Arrays.equals(charArray, charArray1);
  }

  public boolean isAnagram1(String s, String t){
    if (s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++; // Прибавляем для первой строки
      count[t.charAt(i) - 'a']--; // Вычитаем для второй строки
    }

    for (int val : count) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }
}
