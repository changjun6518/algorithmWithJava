package inflearn2.Array;

import java.util.Scanner;

public class 큰수출력하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.print(arr[0] + " ");
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
//6
//7 3 9 5 6 12