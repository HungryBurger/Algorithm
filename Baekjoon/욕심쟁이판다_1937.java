package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 욕심쟁이판다_1937 {

	static int N;
	static int[][] map,dp;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, -0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];
		
		for (int a = 0; a < N; a++) {
			String[] temp = br.readLine().split(" ");
			map[a] = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
		}

		int maxAlive = Integer.MIN_VALUE;
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				maxAlive = Math.max(maxAlive, DFS(a,b));
			}
		}
		System.out.println(maxAlive);
	}

	public static int DFS(int y,int x) {
		if(dp[y][x]!=0)
			return dp[y][x];
		dp[y][x] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if (map[y][x] < map[nextY][nextX]) {
					dp[y][x] = Math.max(dp[y][x], DFS(nextY, nextX) + 1);
				}
			}
		}
		return dp[y][x];
	}
}
