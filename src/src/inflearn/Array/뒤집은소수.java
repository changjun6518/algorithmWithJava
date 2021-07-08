package inflearn.Array;

import java.util.Scanner;

public class 뒤집은소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            String s = sc.next();
            String s1 = new StringBuilder(s).reverse().toString();
            arr[i] = Integer.parseInt(s1);
        }

        for (int i : arr) {
            check(i);
        }




    }

    public static void check(int n) {
        if (n == 1) {
            return;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return;
            }
        }
        System.out.printf(n + " ");
    }
}
