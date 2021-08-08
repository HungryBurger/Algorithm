package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_2146 {

	static boolean[][] visited;
	static int[][] graph;
	static int N;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int k = 0; k < N; k++) {
				graph[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;

		// DFS를 통해서 섬을 번호로 표시
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				if (!visited[i][k] && graph[i][k] == 1) {
					DFS(i, k, cnt++);
				}
			}
		}

		int result = Integer.MAX_VALUE;

		// 각 섬에서 가장 가까운 섬까지 다리를 놓을때 최소 길이 구하기
		for (int i = 1; i < cnt; i++) {
			// 방문 체크 배열 초기화
			for (int k = 0; k < visited.length; k++) {
				Arrays.fill(visited[k], false);
			}
			result = Math.min(result, BFS(i));
		}
		System.out.println(result);
	}

	public static void DFS(int y, int x, int cnt) {
		visited[y][x] = true;
		graph[y][x] = cnt;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if (!visited[nextY][nextX] && graph[nextY][nextX] == 1) {
					DFS(nextY, nextX, cnt);
				}
			}
		}
	}

	public static int BFS(int cnt) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				if (graph[i][k] == cnt) {
					visited[i][k] = true;
					q.offer(new int[] { k, i, 0 });
				}
			}
		}
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int k = 0; k < 4; k++) {
				int nextX = location[0] + dx[k];
				int nextY = location[1] + dy[k];
				int nd = location[2] + 1;
				// 내가 가려는 곳이 범위 안인지 확인
				if (nextY < N && nextY >= 0 && nextX < N && nextX >= 0) {
					if (graph[nextY][nextX] != 0 && graph[nextY][nextX] != cnt) {
						return nd-1;
					} else if (!visited[nextY][nextX] && graph[nextY][nextX] == 0) {
						visited[nextY][nextX] = true;
						q.offer(new int[] { nextX, nextY, nd });
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}
