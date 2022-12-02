import java.util.Arrays;
import java.util.HashMap;

public class CountNonDivisible {

  public static void main(String[] args) {
    //    System.out.println(
    //        Arrays.toString(new CountNonDivisible().solution(new int[] {3, 1, 2, 3, 6})));
    System.out.println(
        Arrays.toString(
            new CountNonDivisible().solution(new int[] {6, 7, 2, 1, 4, 7, 4, 4, 1, 8, 10, 15})));
    //    System.out.println(Arrays.toString(new CountNonDivisible().solution(new int[] {2})));
  }

  public int[] solution(int[] a) {
    int n = a.length;
    int length = n;
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(a[i])) {
        map.put(a[i], map.get(a[i]) + 1);
      } else {
        map.put(a[i], 1);
      }
    }

    var resArr = new int[n];
    for (int i = 0; i < n; i++) {
      var divisors = 0;
      for (int j = 1; j * j <= a[i]; j++) {
        if (a[i] % j == 0) {
          if (map.containsKey(j)) {
            divisors += map.get(j);
          }

          var secMultiplier = a[i] / j;
          if (secMultiplier != j) {
            if (map.containsKey(secMultiplier)) {
              divisors += map.get(secMultiplier);
            }
          }
        }
      }
      resArr[i] = n - divisors;
    }

    return resArr;
  }
}
