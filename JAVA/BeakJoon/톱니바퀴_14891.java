package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class 톱니바퀴_14891 {

	static ArrayList<ArrayList<Integer>> Gear = new ArrayList<ArrayList<Integer>>();
	static int[][] rotate;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		for (int i = 0; i < 4; i++) {
			String s = bf.readLine(); // String
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int k = 0; k < s.length(); k++) {
				// 숫자로 변환
				temp.add(s.charAt(k) - '0');
			}
			Gear.add(temp);
		}
		String str = bf.readLine();
		int count = Integer.parseInt(str);
		rotate = new int[count][2];
		for (int i = 0; i < count; i++) {
			str = bf.readLine();
			String[] temp = new String[2];
			temp = str.split(" ");
			rotate[i][0] = Integer.parseInt(temp[0]);
			rotate[i][1] = Integer.parseInt(temp[1]);
		}

		Solve();

		System.out.println(
				Gear.get(0).get(0) * 1 + Gear.get(1).get(0) * 2 + Gear.get(2).get(0) * 4 + Gear.get(3).get(0) * 8);
	}

	public static void Solve() {
		for (int i = 0; i < rotate.length; i++) {

			// 같은 극이라면 돌릴수없다.
			// 같은 극이 아니라면 돌린다.
			// 1번바퀴 일때.
			if (rotate[i][0] == 1) {
				// 2번도 돌아갈 때
				if (Gear.get(0).get(2) != Gear.get(1).get(6)) {
					// 3번도 돌아갈 때
					if (Gear.get(1).get(2) != Gear.get(2).get(6)) {
						// 4번도 돌아갈 때
						if (Gear.get(2).get(2) != Gear.get(3).get(6)) {
							Rotate_gear(4, rotate[i][1] * -1);
						}
						Rotate_gear(3, rotate[i][1]);
					}
					Rotate_gear(2, rotate[i][1] * -1);
				}
				Rotate_gear(1, rotate[i][1]);
			}
			// 2번 바퀴 일때
			if (rotate[i][0] == 2) {
				// 1번도 돌아갈 때
				if (Gear.get(0).get(2) != Gear.get(1).get(6)) {
					Rotate_gear(1, rotate[i][1] * -1);
				}
				// 3번도 돌아갈때
				if (Gear.get(1).get(2) != Gear.get(2).get(6)) {
					// 4번도 돌아갈때
					if (Gear.get(2).get(2) != Gear.get(3).get(6)) {
						Rotate_gear(4, rotate[i][1]);
					}
					Rotate_gear(3, rotate[i][1] * -1);
				}
				Rotate_gear(2, rotate[i][1]);
			}
			// 3번 바퀴 일때
			if (rotate[i][0] == 3) {
				// 2번도 돌아갈때
				if (Gear.get(1).get(2) != Gear.get(2).get(6)) {
					// 1번도 돌아갈때
					if (Gear.get(0).get(2) != Gear.get(1).get(6)) {
						Rotate_gear(1, rotate[i][1]);
					}
					Rotate_gear(2, rotate[i][1] * -1);
				}
				// 4번도 돌아갈때
				if (Gear.get(2).get(2) != Gear.get(3).get(6)) {
					Rotate_gear(4, rotate[i][1] * -1);
				}
				Rotate_gear(3, rotate[i][1]);
			}
			// 4번 바퀴일 때
			if (rotate[i][0] == 4) {
				// 3번도 돌아갈 때
				if (Gear.get(2).get(2) != Gear.get(3).get(6)) {
					// 2번도 돌아갈 때
					if (Gear.get(1).get(2) != Gear.get(2).get(6)) {
						// 1번도 돌아갈 때
						if (Gear.get(0).get(2) != Gear.get(1).get(6)) {
							Rotate_gear(1, rotate[i][1] * -1);
						}
						Rotate_gear(2, rotate[i][1]);
					}
					Rotate_gear(3, rotate[i][1] * -1);
				}
				Rotate_gear(4, rotate[i][1]);
			}
		}
	}

	public static void Rotate_gear(int Gear_num, int rotate_direction) {
		Gear_num--;
		// 시계 방향
		if (rotate_direction == 1) {
			// 뒤에서 앞으로 넘긴거
			Gear.get(Gear_num).add(0, Gear.get(Gear_num).get(7));
			Gear.get(Gear_num).remove(8);
		}
		// 반 시계 방향
		else {
			// 앞에서 뒤로 넘긴거
			int temp = Gear.get(Gear_num).get(0);
			Gear.get(Gear_num).remove(0);
			Gear.get(Gear_num).add(temp);
		}
	}
}