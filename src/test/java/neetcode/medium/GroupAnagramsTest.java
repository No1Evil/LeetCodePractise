package neetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {

  GroupAnagrams object = new GroupAnagrams();

  @Test
  public void happyPath() {
    String[] strings = new String[] {"act", "pots", "tops", "cat", "stop", "hat"};

    // Оборачиваем в new ArrayList, чтобы списки стали изменяемыми
    List<List<String>> expected = new ArrayList<>(List.of(
        new ArrayList<>(List.of("hat")),
        new ArrayList<>(List.of("act", "cat")),
        new ArrayList<>(List.of("stop", "pots", "tops"))
    ));

    List<List<String>> actual = new ArrayList<>(object.groupAnagrams(strings));

    List<ArrayList<String>> mutableActual = actual.stream()
        .map(ArrayList::new).toList();

    List<ArrayList<String>> mutableExpected = expected.stream()
        .map(ArrayList::new)
        .toList();

    mutableActual.forEach(Collections::sort);
    mutableExpected.forEach(Collections::sort);

    Comparator<List<String>> listComparator = Comparator.comparing(l -> l.get(0));

    List<List<String>> sortedActual = new ArrayList<>(mutableActual);
    List<List<String>> sortedExpected = new ArrayList<>(mutableExpected);

    sortedActual.sort(listComparator);
    sortedExpected.sort(listComparator);

    Assertions.assertEquals(sortedExpected, sortedActual);
  }

}
