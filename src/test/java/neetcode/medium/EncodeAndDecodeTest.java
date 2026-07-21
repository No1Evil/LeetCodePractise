package neetcode.medium;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncodeAndDecodeTest {

  EncodeAndDecode object = new EncodeAndDecode();

  @Test
  public void happyPath() {
    var list = List.of("Hello", "World");

    String encode = object.encode(list);

    List<String> decoded = object.decode(encode);
    Assertions.assertEquals(list.size(), decoded.size(), "Lists should be same size");

    for (int i = 0; i < list.size(); i++) {
      Assertions.assertEquals(list.get(i), decoded.get(i));
    }
  }

}
