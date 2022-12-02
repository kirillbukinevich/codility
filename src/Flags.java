import java.util.ArrayList;
import java.util.List;

public class Flags {

  public static void main(String[] args) {
//    System.out.println(new Flags().solution(new int[] {0, 0, 0, 0, 0, 1, 0, 1, 0, 1}));
    System.out.println(new Flags().solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
  }

  private final List<Integer> peaks = new ArrayList<>();

  public int solution(int[] a) {
    if (a.length == 1) {
      return 0;
    }
    for (int i = 1; i < a.length - 1; i++) {
      if (a[i - 1] < a[i] && a[i + 1] < a[i]) {
        peaks.add(i);
      }
    }

    if(peaks.size() <= 1) {
      return peaks.size();
    }

    var start = 0;
    var end = peaks.size();
    var flag = 0;

    var maxFlagCount = 1;
    while (start <= end) {
      flag = (start + end) / 2;
      var mark = 0;
      var counter = 0;
      var success = false;
      for (int i = 0; i < peaks.size(); i++) {
        if (peaks.get(i)  >= mark) {
          mark = peaks.get(i) + flag;
          counter++;
          if(counter == flag) {
            success = true;
            break;
          }
        }
      }
      if(success) {
        start = flag + 1;
        maxFlagCount = counter;
      } else  {
        end = flag - 1;
      }

    }



    return maxFlagCount;
  }
}
