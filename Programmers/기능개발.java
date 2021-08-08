package com.study;

import java.util.ArrayList;

public class 기능개발 {

    public static void main(String[] args) {
        int[] progresses = {90, 90, 99, 99, 80, 99};
        int[] speeds = {4, 1, 1, 1, 1, 1};
        int[] answer = solution(progresses, speeds);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] days = new int[progresses.length];
        int idx = 0;
        for (int prog : progresses) {
            days[idx] = (int) Math.ceil((double)(100 - prog) / speeds[idx]);
            idx++;
        }
        int maxDay = days[0];

        answerList.add(0);
        for (int day : days) {
            if (maxDay >= day) {
                int nextNum = answerList.get(answerList.size()-1).intValue() + 1;
                answerList.set(answerList.size()-1, nextNum);
            } else {
                maxDay = day;
                answerList.add(1);
            }
        }
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
