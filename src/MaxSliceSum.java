public class MaxSliceSum {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {-2}));
    System.out.println(solution(new int[] {3, 2, -6, 4, 0}));
  }

  public static int solution(int[] arr) {
    var maxSum = Integer.MIN_VALUE;
    var tempSum = 0;
    for (int i = 0; i < arr.length; i++) {
      tempSum += arr[i];
      maxSum = Math.max(tempSum, maxSum);
      tempSum = Math.max(0, tempSum);
    }
    return maxSum;
  }
}
