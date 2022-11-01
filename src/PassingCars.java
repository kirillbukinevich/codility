public class PassingCars {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {0, 1, 0, 1, 1}));
    System.out.println(solution(new int[] {1, 0}));
    System.out.println(solution(new int[] {0, 1}));
  }

  public static int solution(int[] a) {
    var numberOfOnes = 0;
    for (int j : a) {
      if (j == 1) {
        numberOfOnes++;
      }
    }

    var res = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 0) {
        res += numberOfOnes;
        if (res > 1000000000) {
          return -1;
        }
      } else {
        numberOfOnes--;
      }
    }
    return res;
  }
}
