package inflearn.Array;

import java.util.Scanner;

public class 보이는학생 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int count = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
                count++;
            }
        }
        System.out.println(count);
    }
}
