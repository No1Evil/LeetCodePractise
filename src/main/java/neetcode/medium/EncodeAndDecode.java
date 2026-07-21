package neetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {

  public String encode(List<String> strs) {
    StringBuilder builder = new StringBuilder();

    for (var str : strs) {
      int length = str.length();
      builder.append(length).append('#').append(str);
    }

    return builder.toString();
  }

  public List<String> decode(String str) {
    List<String> result = new ArrayList<>();

    int i = 0;
    while (i < str.length()) {
      int slashIndex = str.indexOf('#', i);
      int length = Integer.parseInt(str.substring(i, slashIndex));

      i = slashIndex + 1;

      String s = str.substring(i, i + length);
      result.add(s);

      i += length;
    }

    return result;
  }

}
