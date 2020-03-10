package BaekJoon;

import java.util.*;

public class 미로탐색 {
	static int[][] map;
	static boolean[][] visit;
	static int[] row = { 1, -1, 0, 0 };
	static int[] col = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		// Mapping
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int k = 0; k < temp.length(); k++) {
				map[i][k] = temp.charAt(k) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}

	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { a, b });

		while (!q.isEmpty()) {
			int location[] = q.poll();
			visit[location[0]][location[1]] = true;
			for (int i = 0; i < 4; i++) {
				int next_y = location[0] + row[i];
				int next_x = location[1] + col[i];

				// 좌표 바깥으로 나가는것을 막기 위해
				if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {
					if (map[next_y][next_x] != 0 && !visit[next_y][next_x]) {
						q.offer(new int[] { next_y, next_x});
						visit[next_y][next_x] = true;
						map[next_y][next_x] = map[location[0]][location[1]]+1;
					}
				}
			}
		}
	}
}
