package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장긴증가하는부분수열_11053 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int N = Integer.parseInt(str);
		String[] temp = bf.readLine().split(" ");
		// 숫자들 저장하는 배열
		int[] dp = new int[N];
		int[] data = new int[N];

		// 숫자 변형해서 집어넣기
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(temp[i]);
		}
		// 2중 포문을 이용한 해결방법(O(N^2))
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (data[j] < data[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					// 증가하는 수열 길이를 증가시켜준다
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N - 1]);
	}
}

//
//ArrayList<Integer> LIS = new ArrayList<>();
//LIS.add(data[0]);
//for (int i = 1; i < N; i++) {
//	// 맨 끝값보다 크다면 바로 뒤에 삽입해준다.
//	if (LIS.get(LIS.size() - 1) < data[i]) {
//		LIS.add(data[i]);
//	}
//	// 끝 값보다 작으면
//	else {
//		for (int k = 0; k < LIS.size(); k++) {
//			if (LIS.get(k) == data[i]) {
//				break;
//			} else if (LIS.get(k) > data[i]) {
//				LIS.add(k, data[i]);
//				break;
//			}
//		}
//	}
//}
//System.out.println(LIS.size());