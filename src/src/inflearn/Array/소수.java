package inflearn.Array;

import java.util.Scanner;

public class 소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] ans = new int[num+1];
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (ans[i] == 0) {
                count++;
                for (int j = i; j <= num; j = j + i) {
                    ans[j] = 1;
                }
            }
        }
        System.out.println(count);

    }
}
