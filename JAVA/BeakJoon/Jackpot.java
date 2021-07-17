package com.lotto;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Jackpot {
    /**
     * Main
     * 1단계 모든 숫자 읽기
     * 2단계 새로운 숫자를 뽑는다.
     * 3단계 : validtion 체크
     * 3-1단계 : 실패시 다시 숫자 뽑기
     * 3-2단계 : 성공시 list안에 넣기
     * <p>
     * <p>
     * validation method
     * 1단계 : 이떄까지 뽑혔던 일치하는 경우의 수는 모두 제외한다.
     * 2단계 : 지금 내가 뽑았던 수들 중에 중복되는 숫자가 duplicateNum개 이상 동일하다면 제외한다.
     * 3단계 : 뽑은 수가 연속된 숫자가 seqNum개 이상이라면 제외한다.
     */

    static final int duplicateNum = 3;
    static final int seqNum = 3;

    static ArrayList<int[]> readData = new ArrayList<>();
    static ArrayList<int[]> finalJackPotNum = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("개수 선정");
        Scanner sc = new Scanner(System.in);
        readAllData();
        //Jackpot Number를 뽑는다.
        int howMany = sc.nextInt();

        int i = 0;
        while (true) {
            int[] jackPotNum = getJackPotNumber();
            Arrays.sort(jackPotNum);
            if (validationAllCase(jackPotNum)) {
                finalJackPotNum.add(jackPotNum);
                i++;
                System.out.println(i);
            }
            if (howMany <= i) {
                break;
            }
        }
        i = 1;
        for (int[] jackpotNum : finalJackPotNum) {
            System.out.print(i + "번째 : ");
            for (int num : jackpotNum) {
                System.out.print(num + " ");
            }
            System.out.println();
            if (i % 10 == 0) {
                System.out.println("-----------------------------");
            }
            i++;
        }
    }

    public static int[] getJackPotNumber() {
        Random random = new Random();
        int[] jackpot = new int[6];
        jackpot[0] = random.nextInt(21) + 1;
        jackpot[1] = getSuiteRandNumber(jackpot, 3, 30);
        jackpot[2] = getSuiteRandNumber(jackpot, 10, 37);
        jackpot[3] = getSuiteRandNumber(jackpot, 11, 41);
        jackpot[4] = getSuiteRandNumber(jackpot, 17, 44);
        jackpot[5] = getSuiteRandNumber(jackpot, 23, 45);
        return jackpot;
    }

    public static int getSuiteRandNumber(int[] jackpot, int min, int max) {
        Random random = new Random();
        while (true) {
            int value = random.nextInt(max - min) + min;
            if (!Arrays.stream(jackpot).anyMatch(x -> x == value)) {
                return value;
            }
        }
    }

    public static void readAllData() {
        File file = new File("src/lottoData.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split("\t");
                int[] nums = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
                readData.add(nums);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validationAllCase(int[] jackPotNum) {
        return validationExistNum(jackPotNum) && checkDuplicateNum(jackPotNum) && checkSequenceNum(jackPotNum);
    }

    /**
     * check exist num
     */
    public static boolean validationExistNum(int[] jackPotNum) {
        for (int[] read : readData) {
            if (Arrays.equals(read, jackPotNum)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 뽑았던 숫자들 중에 중복되는 숫자가 4개 이상이라면
     */
    public static boolean checkDuplicateNum(int[] jackPotNum) {
        for (int[] jackpot : finalJackPotNum) {
            int dupleCnt = 0;
            for (int i = 0; i < 6; i++) {
                int tempData = jackPotNum[i];
                if (Arrays.stream(jackpot).anyMatch(x -> x == tempData)) {
                    dupleCnt++;
                }
            }
            if (dupleCnt >= duplicateNum) {
                return false;
            }
        }
        return true;
    }

    /**
     * 연속된 숫자들에 대해서 확인
     */
    public static boolean checkSequenceNum(int[] jackPotNum) {
        int seq = 0;
        for (int i = 0; i < 5; i++) {
            if (jackPotNum[i] + 1 == jackPotNum[i + 1]) {
                seq++;
            }
            if (seq >= seqNum) {
                return false;
            }
        }
        return true;
    }
}
