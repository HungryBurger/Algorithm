package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class LINE_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(">_<"));
    }

    public static int solution(String inputString) {
        int answer = 0;
        ArrayList<Integer> spec1 = new ArrayList<>();
        ArrayList<Integer> spec2 = new ArrayList<>();
        ArrayList<Integer> spec3 = new ArrayList<>();
        ArrayList<Integer> spec4 = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            // ()
            if (inputString.charAt(i) == '(') {
                spec1.add(i);
            }
            if (inputString.charAt(i) == ')') {
                if (spec1.size() > 0) {
                    spec1.remove(0);
                    answer++;
                } else {
                    answer = -1;
                    break;
                }
            }
            // {}
            if (inputString.charAt(i) == '{') {
                spec2.add(i);
            }
            if (inputString.charAt(i) == '}') {
                if (spec2.size() > 0) {
                    spec2.remove(0);
                    answer++;
                } else {
                    answer = -1;
                    break;
                }
            }
            // []
            if (inputString.charAt(i) == '[') {
                spec3.add(i);
            }
            if (inputString.charAt(i) == ']') {
                if (spec3.size() > 0) {
                    spec3.remove(0);
                    answer++;
                } else {
                    answer = -1;
                    break;
                }
            }
            // <>
            if (inputString.charAt(i) == '<') {
                spec4.add(i);
            }
            if (inputString.charAt(i) == '>') {
                if (spec4.size() > 0) {
                    spec4.remove(0);
                    answer++;
                } else {
                    answer = -1;
                    break;
                }
            }

        }
        return answer;
    }

}
