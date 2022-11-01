import java.util.HashSet;

// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
public class MissingInteger {
  public static void main(String[] args) {
    System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));
    System.out.println(solution(new int[] {1}));
    System.out.println(solution(new int[] {3}));
  }

  public static int solution(int[] a) {
    var set = new HashSet<Integer>();
    for (int j : a) {
      if (j > 0) {
        set.add(j);
      }
    }

    for (int i = 1; i <= 1000000; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 1;
  }
}
