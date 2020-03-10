package BaekJoon;
import java.util.*;

public class BFS_DFS {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int[] a = new int[3];

      for (int i = 0; i < 3; i++) {
         a[i] = scan.nextInt();
      }

      int[] from = { 0, 0, 1, 1, 2, 2 };
      int[] to = { 1, 2, 0, 2, 0, 1 };
      boolean[][] check = new boolean[201][201];
      boolean[] ans = new boolean[201];
      Queue<Pair> q = new LinkedList<>();

      q.add(new Pair(0, 0));
      check[0][0] = true;
      ans[a[2]] = true;

      while (!q.isEmpty()) {
         Pair p = q.poll();
         int x = p.x;
         int y = p.y;
         int z = a[2] - x - y;

         for (int k = 0; k < 6; k++) {//여기서 x,y,z값은 안건드리기때문에 for문이 돌때마다 초기화 됨.
            //이 for문은 물을 부을수 있는 6가지 방법에 대해서 for문을 돌리는것임. 즉, DFS가 아니라 BFS인 이유는 여기서 물통을 한번 부어놓은 상태에 대해서 그 방법을 끝까지
            //파고드는것이 아니라 한 방법에 대해서 6가지 모든 경우의 수를 돌리고 한번 더 붓고 큐에 저장된 그 전에 부었던 상태에대해서 한번더 진행하고 이런 방식으로 돌아가기때문에 BFS 인것임.
            int[] next = { x, y, z };
            next[to[k]] += next[from[k]];
            next[from[k]] = 0;//물을 부어주면 from의 물통은 전부 비어버리기때문에 0.

            if (next[to[k]] > a[to[k]]) { // 물통의 용량보다 물이 많을 때a[to[k]]는 초기에 선언해준 물통의 부피.
               next[from[k]] = next[to[k]] - a[to[k]]; // 초과하는 만큼 다시 넣어주고
               next[to[k]] = a[to[k]]; // 용량에 가득 찬 물을 넣어준다.
            }
            if (!check[next[0]][next[1]]) {//A,B 물통을 체크해봤을때 방문한적이 없으면 아래 작업 실시. ex)check[0][0]=true 이기때문에 실행하지않음. 처음에.
               check[next[0]][next[1]] = true;//예를들어 처음에 A,B에 담겨있는 (0,0) 페어를 큐에서 당겨와서 초기에 한번 돌리는작업이다. 그 작업중에 (8,0)(0,9) 페어가 새로 큐에 들어감.
               q.add(new Pair(next[0], next[1]));
               if (next[0] == 0) {//문제 조건에서 A물통이 비어있을때의 C물통이 가질 수 있는 부피의 경우의 수를 물어봤으므로 큐에 새로 추가된 페어중에 A물통에 들은
                  //물의 양이 0일 경우에는 C물통의 양을 기억한다. 즉, ans[next[2]]에다가 저장한다. ex)처음의 경우 ans[9]=true
                  ans[next[2]] = true;
               }
            }
         }
      }
      for (int i = 0; i <= a[2]; i++) {//초기 a[2] 즉, 총 물의양 만큼 for문을 돌린다. A가 비어있을때 C가 가질수 있는 물 부피의 경우의 수는 초기 총 물의 양의수를 넘을 수 없기 때문에.
         if (ans[i])//예제 출력으 경우, ans[1] ans[2] ans[8] ans[9] ans[10]이 true 이므로 5가지 출력.
            System.out.print(i + " ");
      }
   }

}

class Pair {
   int x;
   int y;

   public Pair(int x, int y) {
      this.x = x;
      this.y = y;
   }
}