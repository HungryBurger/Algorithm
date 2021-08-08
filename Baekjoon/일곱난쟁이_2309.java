package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 일곱난쟁이_2309 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        ArrayList<Integer> goblin = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int data = Integer.parseInt(bf.readLine());
            goblin.add(data);
            sum += data;
        }
        // 전체 조회하기
        loop:
        for (int i = 0; i < 9; i++) {
            for (int k = i + 1; k < 9; k++) {
                int result = sum - goblin.get(i) - goblin.get(k);
                if (result == 100) {
                    ArrayList<Integer> deletion = new ArrayList<>();
                    deletion.add(goblin.get(i));
                    deletion.add(goblin.get(k));
                    goblin.removeAll(deletion);
                    break loop;
                }
            }
        }
        Collections.sort(goblin);
        for (int i = 0; i < 7; i++) {
            System.out.println(goblin.get(i));
        }
    }
}
