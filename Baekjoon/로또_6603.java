package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 로또_6603 {
	static int K;
	static int[] visit = new int[6];
	static ArrayList<Integer> data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if (K == 0) {
				break;
			} else {
				data = new ArrayList<>();
				for (int i = 0; i < K; i++) {
					data.add(Integer.parseInt(st.nextToken()));
				}
				DFS(0, 0);
				System.out.println();
			}
		}
	}

	public static void DFS(int start, int length) {
		if (length == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(visit[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < K; i++) {
			visit[length] = data.get(i);
			DFS(i + 1, length + 1);
		}
	}
}
