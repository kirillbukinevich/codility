public class CountFactors {

  public static void main(String[] args) {
    System.out.println(new CountFactors().solution(Integer.MAX_VALUE));
  }

  public int solution(int n) {
    if (n == 1) {
      return 1;
    }
    long i = 1;
    var res = 0;
    while (i * i < n) {
      if (n % i == 0) {
        res += 2;
      }
      i++;
    }
    if (i * i == n) {
      res += 1;
    }
    return res;
  }
}
