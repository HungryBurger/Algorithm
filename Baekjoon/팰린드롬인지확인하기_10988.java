package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬인지확인하기_10988 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        String str = bf.readLine();
        int rev;
        rev = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(rev--)) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
        System.exit(0);
    }
}
