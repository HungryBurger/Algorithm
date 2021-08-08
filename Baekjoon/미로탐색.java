package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] temp = str.split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String tp = bf.readLine();
            for (int k = 0; k < M; k++) {
                map[i][k] = tp.charAt(k) - '0';
            }
        }
        BFS(0, 0);
        System.out.println(map[N - 1][M - 1]);

    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] location = new int[2];
            location = q.poll();
            visit[location[1]][location[0]] = true;
            for (int i = 0; i < 4; i++) {
                int next_x = location[0] + dx[i];
                int next_y = location[1] + dy[i];
                if (next_x < M && next_x >= 0 && next_y < N && next_y >= 0) {
                    if (map[next_y][next_x] != 0 && !visit[next_y][next_x]) {
                        q.offer(new int[]{next_x, next_y});
                        visit[next_y][next_x] = true;
                        map[next_y][next_x] = map[location[1]][location[0]] + 1;
                    }
                }
            }
        }
    }
}

//package BaekJoon;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class 미로탐색 {
//	static int[][] map;
//	static boolean[][] visit;
//	static int[] row = { 1, -1, 0, 0 };
//	static int[] col = { 0, 0, -1, 1 };
//	static int N, M;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String str = bf.readLine();
//		String[] temp = str.split(" ");
//		N = Integer.parseInt(temp[0]);
//		M = Integer.parseInt(temp[1]);
//
//		map = new int[N][M];
//		visit = new boolean[N][M];
//
//		for (int i = 0; i < N; i++) {
//			String tp = bf.readLine();
//			for (int k = 0; k < M; k++) {
//				map[i][k] = (int) tp.charAt(k);
//			}
//		}
//		bfs(0, 0);
//		System.out.println(map[N - 1][M - 1]);
//	}
//
//	public static void bfs(int a, int b) {
//		Queue<int[]> q = new LinkedList<>();
//		q.offer(new int[] { a, b });
//
//		while (!q.isEmpty()) {
//			int location[] = q.poll();
//			visit[location[0]][location[1]] = true;
//			for (int i = 0; i < 4; i++) {
//				int next_y = location[0] + row[i];
//				int next_x = location[1] + col[i];
//
//				// 좌표 바깥으로 나가는것을 막기 위해
//				if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {
//					if (map[next_y][next_x] != 0 && !visit[next_y][next_x]) {
//						q.offer(new int[] { next_y, next_x });
//						visit[next_y][next_x] = true;
//						map[next_y][next_x] = map[location[0]][location[1]] + 1;
//					}
//				}
//			}
//		}
//	}
//}
//
//
//
