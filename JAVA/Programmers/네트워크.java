package Programmers;

import java.util.ArrayList;

public class 네트워크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	static boolean[] check = new boolean[200];
	static int[][] maps;
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		// INIT 셋팅
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			map.add(temp);
		}

		// 1인것만 뽑아내기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1) {
					map.get(i).add(j);
					map.get(j).add(i);
				}
			}
		}
		// 다 돌아보고 VISIT 체크

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				answer++;
				dfs(i);
			}
		}
		return answer;
	}

	public static void dfs(int start) {
		check[start] = true;
		for (int i = 0; i < map.get(start).size(); i++) {
			int next = map.get(start).get(i);
			if (!check[next]) {
				dfs(next);
			}

		}
	}
}
