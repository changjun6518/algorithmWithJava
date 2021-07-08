package inflearn.Array;

import java.util.Scanner;

public class 피보나치수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] pibo = new int[num];
        pibo[0] = 1;
        pibo[1] = 1;


        for (int i = 2; i < num; i++) {
            pibo[i] = pibo[i - 1] + pibo[i - 2];
        }

        for (int i : pibo) {
            System.out.printf(i + " ");
        }
    }
}
