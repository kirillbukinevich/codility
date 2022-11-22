public class MaxProfit {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {}));
    System.out.println(solution(new int[] {1}));
    System.out.println(solution(new int[] {1, 2}));
    System.out.println(solution(new int[] {2, 1}));
    System.out.println(solution(new int[] {4, 3, 2, 1}));
    System.out.println(solution(new int[] {1, 2, 3, 4}));
    System.out.println(solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367}));
  }

  public static int solution(int[] arr) {
    var minIndex = 0;
    var maxProf = 0;
    for (int maxIndex = 1; maxIndex < arr.length; maxIndex++) {
      var tempProf = arr[maxIndex] - arr[minIndex];
      if (tempProf > maxProf) {
        maxProf = tempProf;
      }
      if (arr[maxIndex] < arr[minIndex]) {
        minIndex = maxIndex;
      }
    }
    return maxProf;
  }
}
