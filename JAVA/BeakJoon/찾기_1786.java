package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 찾기_1786 {
    static String origin_str;
    static String search_str;
    static int[] table;
    static LinkedList<Integer> answer = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        origin_str = bf.readLine();
        search_str = bf.readLine();
        KMP();
        System.out.println(answer.size());
        for (int i : answer) {
            System.out.print(i + 1 + " ");
        }
    }

    public static void make_table() {
        table = new int[search_str.length()];
        int j = 0;
        for (int i = 1; i < search_str.length(); i++) {
            while (j > 0 && search_str.charAt(i) != search_str.charAt(j)) {
                //하나라도 매칭되는 것이 있을 경우에.
                j = table[j - 1];
            }
            if (search_str.charAt(i) == search_str.charAt(j)) {
                table[i] = ++j;
            }
        }
    }

    public static void KMP() {
        make_table();
        int n = origin_str.length();
        int m = search_str.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && origin_str.charAt(i) != search_str.charAt(j)) {
                j = table[j - 1];
            }
            if (origin_str.charAt(i) == search_str.charAt(j)) {
                if (j == m - 1) {
                    answer.add(i - m + 1);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }
}
