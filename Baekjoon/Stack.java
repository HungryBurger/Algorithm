import java.io.*;
import java.util.*;

public class Num1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int data = Integer.parseInt(st.nextToken());

		for (int i = 0; i < data; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = String.valueOf(st.nextToken());
			if (oper.equalsIgnoreCase("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (oper.equalsIgnoreCase("pop")) {
				if (stack.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			} else if (oper.equalsIgnoreCase("size")) {
				System.out.println(stack.size());
			} else if (oper.equalsIgnoreCase("empty")) {
				if (stack.size() == 0) {
					System.out.println(1);
				} else
					System.out.println(0);
			} else if (oper.equalsIgnoreCase("top")) {
				if (stack.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}
		}
	}
}
