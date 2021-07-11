package inflearn.twoPointerAndSlidingWindow;

import java.util.Scanner;

public class 연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int pr = 1;
        int pl = 1;
        int sum = 0;
        int count = 0;

        while (pr < n) {
            if (sum <= n) {
                sum += pr++;
                if (sum == n) {
                    count++;
                }
            }

            if (sum > n) {
                sum -= pl++;
                if (sum == n) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
