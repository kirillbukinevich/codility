import java.util.ArrayList;
import java.util.List;

public class Peaks {

  public static void main(String[] args) {
    System.out.println(new Peaks().solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
  }

  private final List<Integer> peaks = new ArrayList<>();

  public int solution(int[] a) {

    int arrLen = a.length;
    for (int i = 1; i < arrLen - 1; i++) {
      if (a[i - 1] < a[i] && a[i + 1] < a[i]) {
        peaks.add(i);
      }
    }

    var len = peaks.size();

    for (int numBlocks = len; numBlocks > 0; numBlocks--) {
      if (arrLen % numBlocks == 0) {
        var blockSize = arrLen / numBlocks;
        var ithOkBlock = 0;

        for (var peakIndex : peaks) {
          if (peakIndex / blockSize == ithOkBlock) {
            ithOkBlock++;
          }
        }

        if (ithOkBlock == numBlocks) {
          return numBlocks;
        }
      }
    }

    return 0;
  }
}
