package inflearn.Array;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        10
//1 0 1 1 1 0 0 1 1 0
        int num = sc.nextInt();
        int[] arr = new int[num];
        int[] arr2 = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int score = 0;
        arr2[0] = arr[0];
        for (int i = 1; i < num; i++) {
            if (arr[i] == 1) {
                if (arr2[i - 1] != 0) {
                    arr2[i] = arr2[i - 1] + 1;
                } else {
                    arr2[i] = 1;
                }
            } else {
                arr2[i] = 0;
            }
        }

        for (int i : arr2) {
            score += i;
        }
        System.out.println(score);
    }
}
