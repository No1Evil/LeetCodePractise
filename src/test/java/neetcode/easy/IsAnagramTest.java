package neetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shared.PerformanceMeter;

public class IsAnagramTest extends PerformanceMeter<Boolean> {

  IsAnagram object = new IsAnagram();

  @Test
  public void happyPath() {
    Assertions.assertTrue(object.isAnagram("racecar", "carrace"));
  }

  @Test
  public void endPath() {
    Assertions.assertFalse(object.isAnagram("jar", "jam"));
  }

  @Override
  public Boolean executeTestCase() {
    return object.isAnagram("racecar", "carrace");
  }
}
