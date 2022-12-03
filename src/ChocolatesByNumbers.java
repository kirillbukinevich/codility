public class ChocolatesByNumbers {
  public static void main(String[] args) {
    System.out.println(new ChocolatesByNumbers().solution(10, 4));
  }

  public int solution(int n, int m) {
    var div = 0;
    var temp = n;
    var mode = 0;

    while (temp > 0) {
      mode = temp % m;
      if (mode == 0) {
        div = m;
        break;
      }
      temp = Math.max(mode, m);
      m = Math.min(mode, m);
    }

    return n / div;
  }
}
