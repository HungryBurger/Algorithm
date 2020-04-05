package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LINE_5 {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = { "t1", "t2", "t3" };
		System.out.println(solution(dataSource, tags));
	}
	public static String[] solution(String[][] dataSource, String[] tags) {
		int[] max = new int[dataSource.length];
		int[] count = new int[dataSource.length];
		for (int i = 0; i < dataSource.length; i++) {
			// tag 확인
			for (int z = 0; z < tags.length; z++) {
				for (int k = 1; k < dataSource[i].length; k++) {
					if (tags[z].equals(dataSource[i][k])) {
						count[i]++;
						max[i]++;
					}
				}
			}
		}
		Arrays.sort(max);
		int temp = max[dataSource.length - 1];
		ArrayList<String> data = new ArrayList<>();
		while (temp!=0) {
			for (int i = 0; i < count.length; i++)
			{
				if (temp == count[i]) {
					data.add(dataSource[i][0]);
				}
			}
			temp--;
		}
		
		String[] answer = new String[data.size()];
		int size=0;
		for(String tp : data){
		  answer[size++] = tp;
		}
		return answer;
	}
}