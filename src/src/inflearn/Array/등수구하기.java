package inflearn.Array;

import java.util.Scanner;

public class 등수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5
//87 89 92 100 76
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
            count++;
            System.out.printf(count + " ");
        }

    }
}
