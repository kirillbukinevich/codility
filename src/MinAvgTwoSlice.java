public class MinAvgTwoSlice {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
    System.out.println(solution(new int[] {-100, 1, 5, -3, 10}));
    System.out.println(solution(new int[] {5, -1, -2, -3, 10, -4, -5, -6}));
    System.out.println(solution(new int[] {1, 1, 1, 1}));
  }

  public static int solution(int[] a) {

    var maxSum = Double.MAX_VALUE;
    var sum1 = 0;
    var curAver1 = Double.MAX_VALUE;
    var sum2 = 0;
    var curAver2 = Double.MAX_VALUE;
    var resStartPointer = 0;

    for (int i = 0; i < a.length - 2; i++) {
      sum1 = (a[i] + a[i + 1]);
      curAver1 = sum1 / 2.0d;
      if (curAver1 < maxSum) {
        maxSum = curAver1;
        resStartPointer = i;
      }

      sum2 = sum1 + a[i + 2];
      curAver2 = sum2 / 3.0d;
      if (curAver2 < maxSum) {
        maxSum = curAver2;
        resStartPointer = i;
      }
    }

    curAver1 = (a[a.length - 2] + a[a.length - 1]) / 2.0d;
    if (curAver1 < maxSum) {
      resStartPointer = a.length - 2;
    }

    return resStartPointer;
  }
}
