import java.util.*;

public class MaxSum {
  private static List<Integer> getBigList(){
    List<Integer> bigList = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i <= 10000000; i++){
      bigList.add(random.nextInt(500) + 1);
    }

    return bigList;
  }

  public static int findMaxSum(List<Integer> list) {
    int firstMax = 0;
    int secondMax = 0;

    for (int item : list) {
      if(item < firstMax && item > secondMax){
        secondMax = item;
      } else if(item > firstMax) {
        secondMax = firstMax;
        firstMax = item;
      }
    }

    return firstMax + secondMax;
  }

  public static int findMaxSum2(List<Integer> list) {
    list.sort(Comparator.reverseOrder());

    return list.stream().limit(2).reduce(0, Integer::sum);
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(5, 9, 7, 11);
    List<Integer> bigList = getBigList();

    Long start = Calendar.getInstance().getTimeInMillis();
    System.out.println(findMaxSum(list));
//    System.out.println(findMaxSum(bigList));
    Long end = Calendar.getInstance().getTimeInMillis();

    System.out.println("Diff: " + (end - start));
  }
}