package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class LINE_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(solution("111011110011111011111100011111", 3));
	}

	public static int solution(String road, int n) {
		int answer = 0;
		ArrayList<Integer> data = new ArrayList<>();
		for (int i = 0; i < road.length(); i++) {
			if (road.charAt(i) == '0') {
				data.add(i);
			}
		}
		if (n >= data.size()) {
			return road.length();
		} else {
			for (int i = 0; i < n; i++) {
				int max = 0;
				int max_idx = 0;

				for (int k = 0; k < data.size(); k++) {
					int temp;
					if (k == 0) {
						temp = Math.abs(0 - data.get(k + 1));
					} else if (k == data.size() - 1) {
						temp = Math.abs(road.length() - data.get(k - 1));
					} else {
						temp = Math.abs(data.get(k - 1) - data.get(k + 1)) - 1;
					}
					if (max < temp) {
						max = temp;
						max_idx = k;
						answer = temp;
					}

				}
				data.remove(max_idx);
			}
		}
		return answer;
	}

}

//int front_dis = 0;
//int back_dis = 0;
//if (max_idx - 1 >= 0 && max_idx + 1 < data.size()) {
//	front_dis = Math.abs(data.get(max_idx + 1) - data.get(max_idx - 1));
//	answer = front_dis;
//}
//if (max_idx + 2 < data.size()) {
//	back_dis = Math.abs(data.get(max_idx) - data.get(max_idx + 2));
//}
//if (front_dis != 0 && back_dis != 0) {
//	if (front_dis < back_dis) {
//		answer = back_dis;
//		max_idx += 1;
//	}
//}
