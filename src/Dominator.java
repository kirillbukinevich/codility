import java.util.LinkedList;

public class Dominator {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {4, 3, 4, 3, 4, 3, 4, 4, 3}));
  }

  private static final LinkedList<Integer> list = new LinkedList<>();

  public static int solution(int[] arr) {
    var candidate = -1;
    var index = -1;
    for (int j : arr) {
      if (list.isEmpty()) {
        list.add(j);
      } else if (list.getLast() == j) {
        list.add(j);
      } else {
        list.removeLast();
      }
    }

    if (!list.isEmpty()) {
      candidate = list.get(0);
    }

    var half = arr.length / 2;
    var counter = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == candidate) {
        counter++;
        index = i;
      }
    }
    if (counter > half) {
      return index;
    } else {
      return -1;
    }
  }
}
