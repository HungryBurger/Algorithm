package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
	static int M, N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static ArrayList<int[]> tomato = new ArrayList<>();
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				if (map[i][k] == 1) {
					tomato.add(new int[] { i, k });
					visit[i][k] = true;
				}

			}
		}
		BFS();
		System.out.println(answer);
	}

	public static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < tomato.size(); i++) {
			q.add(new int[] { tomato.get(i)[0], tomato.get(i)[1], 0 });
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now[0] + dy[i];
				int nextX = now[1] + dx[i];
				int nextL = now[2] + 1;
				if (nextY < N && nextY >= 0 && nextX < M && nextX >= 0) {
					if (!visit[nextY][nextX] && map[nextY][nextX] == 0) {
						q.add(new int[] { nextY, nextX, nextL });
						map[nextY][nextX] = 1;
						visit[nextY][nextX] = true;
						answer = nextL;
					}
				}
			}
		}
		loop: for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				if (map[i][k] == 0) {
					answer = -1;
					break loop;
				}
			}
		}
	}
}
