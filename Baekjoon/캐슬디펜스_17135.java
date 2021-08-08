package BaekJoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캐슬디펜스_17135 {

	static int N, M, D;
	static int[][] map, clone;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		clone = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(result);

	}

	static int[] sel = new int[3];
	static int result = 0;
	
	//궁수를 배치시킬 수 있는 모든 조합 구하기
	static void comb(int idx, int selidx) {
		if (selidx == 3) {
			result = Math.max(result, simul());
			return;
		}
		if (idx >= M)
			return;

		sel[selidx] = idx;
		comb(idx + 1, selidx + 1);

		comb(idx + 1, selidx);
	}
	// 각 궁수가 자신의 위치에서 조건에 맞춰 죽일 적을 찾아 배열에 저장 해두기
	static void clonemap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				clone[i][j] = map[i][j];
			}
		}
	}
	//죽일 적을 모두 찾으면 적을 죽여 죽인 적의 숫자를 카운트하기 단 같은 적을 죽이면 카운트 하지 않기
	static int simul() {
		clonemap();
		int cnt = 0;
		while (true) {
			cnt += kill();
			if (down() == 0)
				break;
		}
		
		return cnt;
	}

	static int kill() {
		//그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
		//같은 적이 여러 궁수에게 공격당할 수 있다.
		int killman = 0;
		Point[] deathPoint = new Point[3];
		loop:for (int arr = 0 ; arr < 3 ; arr++) {
			int arrow = sel[arr];
			for (int d = 1; d <= D; d++) {
				for(int j = -d+1 ; j <= d-1 ; j++ ) { //i는 활쏠 row j는 활쏠 col
					int i = (d - Math.abs(j));
					if(i<0 || i >= N)
						continue;
					if(arrow +j >= 0 && arrow+j <M) {
						if(clone[N-i][arrow+j] == 1) {
							deathPoint[arr] = new Point(i,j);
							continue loop;
						}
							
					}
				}
			}
		}
		for(int idx = 0 ; idx< 3 ; idx++) {
			if(deathPoint[idx] == null)
				continue;
			int i = deathPoint[idx].x;
			int j = deathPoint[idx].y;
			int arrow = sel[idx];
			if(clone[N-i][arrow+j] == 0)
				continue;
			clone[N-i][arrow+j] = 0;
			killman++;
		}
		return killman;
	}

	static int down() {
		int remain = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (clone[i][j] == 1) {
					clone[i][j] = 0;
					if (i + 1 >= N)
						continue;
					clone[i + 1][j] = 1;
					remain++;
				}
			}
		}
		return remain;
	}
}
