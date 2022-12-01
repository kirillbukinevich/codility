public class MinPerimeterRectangle {
  public static void main(String[] args){
    System.out.println(new MinPerimeterRectangle().solution(36));
  }

  public int solution(int n) {
    long i = 1;
    var minDiff = n - 1;
    var a = n;
    var b = 1;
    while (i * i < n) {
      if(n % i == 0) {
        int tempA = (int) i;
        int tempB = (int) (n / i);
        int tempMinDiff = tempB - tempA;
        if(tempMinDiff < minDiff) {
          a = tempA;
          b = tempB;
          minDiff = tempMinDiff;
        }
      }
      i++;
    }
    if(i * i == n) {
      return (int) ((i + i) * 2);
    }
    return (a + b) * 2;
  }
}
