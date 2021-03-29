package BaekJoon;

import java.util.Scanner;

public class 하노이의탑이동순서_11729 {

	/**
	 * StringBuilder는 String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 
	 * 기존의 데이터에 더하는 방식을 사용하기 때문에 속도도 빠르며 상대적으로 부하가 적다. 
	 * 따라서 긴 문자열을 더하는 상황이 발생할 경우 StringBuilder를 적극적으로 사용하면 되겠다.
	 */
	static int n, cnt=0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);	
		n = sc.nextInt();
		hanoi(n,1,2,3);
	}
	
	
	public static void hanoi(int n,int from,int by,int to) {
		cnt++;
		if (n == 1) {
			sb.append(from + " " + to + "\n");
			return;
		} else { 
			hanoi(n - 1, from, to, by); // n-1을 한 후, 1->3->2로 원판을 전달
			sb.append(from + " " + to + "\n");
			hanoi(n - 1, by, from, to); // n-1을 한 후, 2->1->3으로 원판을 전달
		}
	}
}
