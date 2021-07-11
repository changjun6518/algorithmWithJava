package inflearn.twoPointerAndSlidingWindow;

import java.util.Scanner;

public class 연속부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int pl = 0;
        int pr = 0;
        int sum = 0;
        int count = 0;

        while (pr < n) {
            if (sum > target) {
                sum -= arr[pl++];
                if (sum == target) {
                    count++;
                }
            }
            if (sum <= target) {
                sum += arr[pr++];
                if (sum == target) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
