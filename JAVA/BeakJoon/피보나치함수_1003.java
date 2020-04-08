package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 피보나치함수_1003 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int T = Integer.parseInt(str);
		int[][] data = new int[40][2];
		data[0] = new int[] { 1, 0 };
		data[1] = new int[] { 0, 1 };
		for (int i = 2; i < 40; i++) {
			for (int k = 0; k < 2; k++) {
				data[i][k] = data[i - 1][k] + data[i - 2][k];
			}
		}
		for (int i = 0; i < T; i++) {
			str = bf.readLine();
			int num = Integer.parseInt(str);
			System.out.println(data[num][0] + " " + data[num][1]);
		}
	}
}
