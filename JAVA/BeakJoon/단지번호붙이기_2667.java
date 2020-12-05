import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] apartment;
	static boolean[][] visited;
	static int apartCount = 0;
	static int size;
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		apartment = new int[size][size];
		visited = new boolean[size][size];

		// 배열에 변환해서 형태만들기
		for (int rowNum = 0; rowNum < size; rowNum++) {
			String rowData = sc.next();
			for (int colNum = 0; colNum < size; colNum++) {
				apartment[rowNum][colNum] = rowData.charAt(colNum) - '0';
			}
			Arrays.fill(visited[rowNum], false);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(!visited[i][j] && apartment[i][j]==1) {
					bfs(j, i);
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[y][x]=true;
		int apartment_cnt = 1;
		// 시작점으로부터 모든 방향 탐색
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int next_x = location[0] + dx[i];
				int next_y = location[1] + dy[i];
				// 범위 설정
				if (next_x >= 0 && next_y >= 0 && next_x < size && next_y < size) {
					// 방문하지 않고 집이라면
					if (!visited[next_y][next_x] && apartment[next_y][next_x] == 1) {
						q.offer(new int[] { next_x, next_y });
						visited[next_y][next_x] = true;
						apartment_cnt++;
					}
				}
			}
		}
		if (apartment_cnt != 0) {
			answer.add(apartment_cnt);
		}
	}
}