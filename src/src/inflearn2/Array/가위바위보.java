package inflearn2.Array;

import java.util.Scanner;

public class 가위바위보 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                System.out.println("D");
            } else if (A[i] == 1 && B[i] == 3) {
                System.out.println("A");
            } else if (A[i] == 2 && B[i] == 1) {
                System.out.println("A");
            } else if (A[i] == 3 && B[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }
}
//5
//2 3 3 1 3
//1 1 2 2 3
