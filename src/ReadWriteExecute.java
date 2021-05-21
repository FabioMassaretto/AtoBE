import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadWriteExecute {
  public static int symbolicToOctal(String permString) {
    String firstBlock = permString.substring(0,3);
    String secBlock = permString.substring(3,6);
    String thirdBlock = permString.substring(6);
    List<String> list = Arrays.asList(firstBlock, secBlock, thirdBlock);

    Map<Character, Integer> map = new HashMap<>();
    map.put('r', 4);
    map.put('w', 2);
    map.put('x', 1);
    map.put('-', 0);

    StringBuilder total = new StringBuilder();

    for (String a: list) {
      int sum = 0;
      for (int i = 0; i < 3; i++){
        if(map.containsKey(a.charAt(i))) {
          sum += map.get(a.charAt(i));
        }
      }
      total.append(sum);
    }

    return Integer.parseInt(total.toString());
  }

  public static void main(String[] args) {
    // Should write 752
    System.out.println(ReadWriteExecute.symbolicToOctal("rwxr-x-w-"));
  }
}