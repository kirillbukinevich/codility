import java.util.Arrays;

// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
public class MaxCounters {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(solution(5, new int[] {3, 4, 4, 6, 1, 4, 4, 6, 6, 6, 6, 6, 5, 6})));
  }

  public static int[] solution(int n, int[] a) {
    int[] res = new int[n];
    n = n + 1;
    var maxCounter = 0;
    var lastResetCounter = 0;
    for (int j : a) {
      if (j < n) {
        res[j - 1] = Math.max(lastResetCounter, res[j - 1]);
        res[j - 1]++;
        maxCounter = Math.max(maxCounter, res[j - 1]);
      } else {
        lastResetCounter = maxCounter;
      }
    }

    for (int i = 0; i < res.length; i++) {
      res[i] = Math.max(lastResetCounter, res[i]);
    }

    return res;
  }
}
