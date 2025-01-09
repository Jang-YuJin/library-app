package com.group.libraryapp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int tryNum = scanner.nextInt();
        int diceNum = 12;

        int[] dice = new int[diceNum];
        Arrays.fill(dice, 0);

        rollDice(tryNum, diceNum, dice);

        showResult(dice);
    }

    public static int[] rollDice(int tryNum, int diceNum, int[] dice) {
        for(int i = 0; i < tryNum; i++) {
            double diceNums = Math.random() * diceNum;
            dice[(int)diceNums]++;
        }
        return dice;
    }

    public static void showResult(int[] dice) {
        for(int i = 0; i < dice.length; i++) {
            System.out.printf("%d은(는) %d번 나왔습니다.\n", i + 1, dice[i]);
        }
    }
}
