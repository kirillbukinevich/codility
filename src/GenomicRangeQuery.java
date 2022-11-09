import java.util.Arrays;

public class GenomicRangeQuery {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("AC", new int[] {0, 0, 1}, new int[] {0, 1, 1})));
    System.out.println(
        Arrays.toString(solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6})));
  }

  public static int[] solution(String s, int[] p, int[] q) {
    var occurrences = new int[3][s.length() + 1];

    for (int i = 0; i < s.length(); i++) {
      int a = 0, c = 0, g = 0;
      if (s.charAt(i) == 'A') {
        a = 1;
      } else if (s.charAt(i) == 'C') {
        c = 1;
      } else if (s.charAt(i) == 'G') {
        g = 1;
      }
      occurrences[0][i + 1] = occurrences[0][i] + a;
      occurrences[1][i + 1] = occurrences[1][i] + c;
      occurrences[2][i + 1] = occurrences[2][i] + g;
    }

    var result = new int[p.length];

    for (int i = 0; i < p.length; i++) {
      var fromIndex = p[i];
      var toIndex = q[i] + 1;
      if (occurrences[0][toIndex] - occurrences[0][fromIndex] > 0) {
        result[i] = 1;
      } else if (occurrences[1][toIndex] - occurrences[1][fromIndex] > 0) {
        result[i] = 2;
      } else if (occurrences[2][toIndex] - occurrences[2][fromIndex] > 0) {
        result[i] = 3;
      } else {
        result[i] = 4;
      }
    }
    return result;
  }
}
