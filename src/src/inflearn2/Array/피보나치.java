package inflearn2.Array;

import java.util.Scanner;

public class 피보나치 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
