import java.util.*;

public class MaxSum {
  private static List<Integer> getBigList(){
    List<Integer> bigList = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i <= 100000; i++){
      bigList.add(random.nextInt(500) + 1);
    }

    return bigList;
  }

  public static int findMaxSum(List<Integer> list) {
    List<Integer> linkedListRef = new LinkedList<>(list);
    linkedListRef.sort(Comparator.reverseOrder());

    int max1 = linkedListRef.get(0);
    linkedListRef.remove(0);
    int max2 = linkedListRef.get(0);
    return max1 + max2;
  }

  public static int findMaxSum2(List<Integer> list) {
    list.sort(Comparator.reverseOrder());

    return list.stream().limit(2).reduce(0, Integer::sum);
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(5, 9, 7, 11);

    Long start = Calendar.getInstance().getTimeInMillis();
    System.out.println(findMaxSum(getBigList()));
//    System.out.println(findMaxSum(list));
    Long end = Calendar.getInstance().getTimeInMillis();

    System.out.println("Diff: " + (end - start));
  }
}