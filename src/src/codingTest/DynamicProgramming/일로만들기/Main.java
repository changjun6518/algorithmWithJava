package codingTest.DynamicProgramming.일로만들기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[1000001];
        arr[0] = arr[1] = 0;
        System.out.println(recur(arr, N));
    }

    public static int recur(Integer[] arr, int N) {
        if (arr[N] == null) {
            if (N % 6 == 0) {
                arr[N] = Math.min(recur(arr, N - 1), Math.min(recur(arr, N / 3), recur(arr, N / 2))) + 1;
            } else if (N % 3 == 0) {
                arr[N] = Math.min(recur(arr, N / 3), recur(arr, N - 1)) + 1;
            } else if (N % 2 == 0) {
                arr[N] = Math.min(recur(arr, N / 2), recur(arr, N - 1)) + 1;
            } else {
                arr[N] = recur(arr, N - 1) + 1;
            }
        }
        return arr[N];
    }

}
