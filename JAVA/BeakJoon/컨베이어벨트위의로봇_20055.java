package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 컨베이어벨트위의로봇_20055 {

	/*
	 * 1. 벨트가 먼저 한칸 이동 2. 모든 로봇이 한칸씩 움직인다. 인덱스 별로 관리 3. 이때 옮기려는 곳에 로봇이 없어야하며, 그 칸의
	 * 내구도가 1이상 남아있어야한다. 4. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다. 5. 내구도가 0인 칸의 개수가 K개 이상이라면
	 * 과정을 종료한다.
	 */

	static ArrayList<Integer> robot = new ArrayList<>();
	static int[] arr;
	static int head = 0;
	static int K;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		int maxSize = N * 2;
		arr = new int[maxSize];

		for (int i = 0; i < maxSize; i++) {
			arr[i] = sc.nextInt();
		}
		int answer = 0;
		while (true) {
			answer++;
			// 회전
			if (head == 0) {
				head = maxSize;
			} else {
				head--;
			}
			// 로봇들 이동하고 새로 생성
			moveRobot();

			// 내구도가 K개 이상이라면
			if (outValidation()) {
				break;
			}
		}
		System.out.println(answer);
	}

	// 로봇을 한칸씩 이동.
	public static void moveRobot() {
		for (int i = 0; i < robot.size(); i++) {
			// 1이상이고 그 부분에 해당 로봇이 없다면
			if (arr[robot.get(i) - 1] >= 1 && !robot.contains(robot.get(robot.get(i) + 1))) {
				robot.set(i, robot.get(i) + 1);
				arr[robot.get(i) + 1]--;
			}
			//떨어뜨려준다.
			if (robot.get(i) > Math.abs(head - (N + 1)) && robot.get(i) < head) {
				robot.remove(i);
			}
		}
		if (arr[head] >= 1 && !robot.contains(robot.get(head))) {
			robot.add(head);
			arr[head]--;
		}
	}

	// 내구도가 K개 이상이라면
	public static boolean outValidation() {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				temp++;
			}
		}
		if (temp == K) {
			return true;
		} else {
			return false;
		}
	}

}
