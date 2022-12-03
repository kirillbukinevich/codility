import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSemiprimes {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            new CountSemiprimes()
                .solution(50, new int[] {1, 2, 3, 4, 10}, new int[] {50, 49, 48, 40, 30})));
    System.out.println(
        Arrays.toString(
            new CountSemiprimes().solution(26, new int[] {1, 4, 1}, new int[] {26, 10, 26})));
    System.out.println(
        Arrays.toString(new CountSemiprimes().solution(26, new int[] {1}, new int[] {26})));
  }

  public int[] solution(int n, int[] p, int[] q) {
    var primes = new ArrayList<Integer>();
    for (int i = 2; i <= n / 2; i++) {
      var isPrime = true;
      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0 && i != j) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        primes.add(i);
      }
    }

    List<Integer> semiPrimes = new ArrayList<Integer>();
    for (int i = 0; i < primes.size(); i++) {
      for (int j = i; j < primes.size(); j++) {
        int semiPrime = primes.get(i) * primes.get(j);
        if (semiPrime > n) {
          break;
        }
        semiPrimes.add(semiPrime);
      }
    }

    semiPrimes = semiPrimes.stream().sorted().collect(Collectors.toList());

    var res = new int[p.length];
    for (int i = 0; i < p.length; i++) {
      var counter = 0;
      for (var semiPrime : semiPrimes) {
        if (semiPrime < p[i]) {
          continue;
        }
        if (semiPrime >= p[i] && semiPrime <= q[i]) {
          counter++;
        } else {
          break;
        }
      }
      res[i] = counter;
    }

    return res;
  }
}
