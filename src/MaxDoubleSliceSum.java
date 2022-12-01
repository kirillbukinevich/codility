public class MaxDoubleSliceSum {

  public static void main(String[] args) {
    System.out.println(new MaxDoubleSliceSum().solution(new int[] {3, -10, 6, -1, 4, 5, -1, 2}));
  }

  public int solution(int[] a) {
    var sliceMax1 = new int[a.length];
    var sliceMax2 = new int[a.length];
    for (int i = 1; i < a.length - 1; i++) {
      sliceMax1[i] = Math.max(sliceMax1[i - 1] + a[i], 0);
    }

    for (int i = a.length - 2; i > 0; i--) {
      sliceMax2[i] = Math.max(sliceMax2[i + 1] + a[i], 0);
    }

    var maxDoubleSliveSum = 0;
    for (int i = 1; i < a.length - 1; i++) {
      maxDoubleSliveSum = Math.max(maxDoubleSliveSum, sliceMax1[i - 1] + sliceMax2[i + 1]);
    }

    return maxDoubleSliveSum;
  }
}
