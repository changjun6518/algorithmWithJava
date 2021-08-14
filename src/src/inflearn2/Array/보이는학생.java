package inflearn2.Array;

import java.util.Scanner;

public class 보이는학생 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            if (max < i) {
                count++;
                max = i;
            }
        }
        System.out.println(count);
    }
}
//8
//130 135 148 140 145 150 150 153