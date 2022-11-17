import java.util.LinkedList;

public class EquiLeader {

  public static void main(String[] args) {
    //    System.out.println(solution(new int[] {4, 3, 4, 3, 4, 3, 4, 4, 3}));
    System.out.println(solution(new int[] {4, 3, 4, 4, 4, 2}));
    System.out.println(solution(new int[] {1, 2, 1, 2, 1, 2, 2, 2}));
    System.out.println(solution(new int[] {1, 2, 2, 2, 1, 2, 1, 2}));
  }

  private static int leaderValue;

  public static int solution(int[] arr) {
    int leaderCounter = getLeaderCounter(arr, arr.length);
    if (leaderCounter == -1) {
      return 0;
    }
    var result = 0;
    int leaderCounter1 = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == leaderValue) {
        leaderCounter1++;
      }

      if (leaderCounter1 > (i + 1) / 2
          && leaderCounter - leaderCounter1 > (arr.length - i - 1) / 2) {
        result++;
      }
    }
    return result;
  }

  private static int getLeaderCounter(int[] arr, int endIndex) {
    var list = new LinkedList<Integer>();
    for (int i = 0; i < endIndex; i++) {
      if (list.isEmpty() || list.getLast() == arr[i]) {
        list.add(arr[i]);
      } else {
        list.removeLast();
      }
    }
    var counter = 0;
    if (!list.isEmpty()) {
      var candidate = list.getLast();
      var half = endIndex / 2;
      for (int i = 0; i < endIndex; i++) {
        if (arr[i] == candidate) {
          counter++;
        }
      }
      if (counter > half) {
        leaderValue = candidate;
        return counter;
      }
    }
    return -1;
  }
}
