import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MaxSum {
  private static int sum = 0;
  public static int findMaxSum(List<Integer> list) {
    int max1 = list.stream().max(Comparator.naturalOrder()).get();
    list.remove(list.stream().max(Comparator.naturalOrder()).get());
    int max2 = list.stream().max(Comparator.naturalOrder()).get();
    return max1 + max2;
  }

  public static void main(String[] args) {
    List<Integer> listRef = Arrays.asList(5, 9, 7, 11);
    List<Integer> linkedListRef = new LinkedList<>(listRef);

    System.out.println(findMaxSum(linkedListRef));
  }
}