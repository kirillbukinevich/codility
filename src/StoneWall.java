import java.util.LinkedList;

public class StoneWall {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}));
  }

  public static int solution(int[] H) {
    var list = new LinkedList<Integer>();
    var res = 0;
    for (int h : H) {
      while (!list.isEmpty() && h < list.getLast()) {
        list.removeLast();
      }

      if (list.isEmpty() || h > list.getLast()) {
        res++;
        list.add(h);
      }
    }
    return res;
  }
}
