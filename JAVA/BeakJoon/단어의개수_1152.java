package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어의개수_1152 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String s = bf.readLine(); 
		StringTokenizer st = new StringTokenizer(s); 
		String array[] = s.split(" ");
		int count=0;
		for(String value:array) {
			if(value.length()>0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
