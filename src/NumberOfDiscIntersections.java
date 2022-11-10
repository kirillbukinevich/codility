import java.util.Arrays;
import java.util.Comparator;

public class NumberOfDiscIntersections {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {}));
    System.out.println(solution(new int[] {1, 5, 2, 1, 4, 0}));
  }

  // 1. split all data to array of points, with coordinate x and boolean isStart
  // 2. sort by x in ASC order
  // 3. iterate over each point and update counter depending on isStart parameter
  // 4. on each iteration step add current counter
  public static int solution(int[] a) {
    var pairs = new Pair[a.length * 2];
    var j = 0;
    for (int i = 0; i < a.length; i++) {
      pairs[j] = new Pair(i - (long) a[i], true);
      j++;
      pairs[j] = new Pair(i + (long) a[i], false);
      j++;
    }
    Arrays.sort(pairs, new Pair(0, true));

    var res = 0;
    var curr = 0;
    for (Pair pair : pairs) {
      if (pair.isStart) {
        res += curr;
        if (res > 10000000) {
          return -1;
        }
        curr++;
      } else {
        curr--;
      }
    }
    return res;
  }

  static class Pair implements Comparator<Pair> {
    long x;
    boolean isStart;

    public Pair(long x, boolean isStart) {
      this.x = x;
      this.isStart = isStart;
    }

    @Override
    public int compare(Pair pair1, Pair pair2) {
      if (pair1.x > pair2.x) {
        return 1;
      } else if (pair1.x < pair2.x) {
        return -1;
      } else {
        if (pair1.isStart && !pair2.isStart) {
          return -1;
        } else if (!pair1.isStart && pair2.isStart) {
          return 1;
        } else {
          return 0;
        }
      }
    }
  }
}
