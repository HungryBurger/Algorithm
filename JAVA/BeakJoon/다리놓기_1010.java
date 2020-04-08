package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다리놓기_1010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split(" ");
			int[] data = new int[2];

			solution(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
		}
	}

	public static int solution(int a, int b) {
		
	}
}
