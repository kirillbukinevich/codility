public class CountDiv {
  public static void main(String[] args) {
    System.out.println(solution(6, 11, 2));
    System.out.println(solution(6, 7, 4));
  }

  public static int solution(int a, int b, int k) {
    var start = -1;
    for (int i = a; i <= b; i++) {
      if (i % k == 0) {
        start = i;
        break;
      }
    }
    if (start == -1) {
      return 0;
    } else {
      return (b - start) / k + 1;
    }
  }
}
