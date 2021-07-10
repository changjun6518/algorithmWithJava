package inflearn.twoPointerAndSlidingWindow;

import java.util.Scanner;

public class 최대매출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int answer ,sum = 0;
        for (int i = 0; i < m; i++) {
            sum += a[i];
        }
        answer = sum;
        for (int i = m; i < n; i++) {
            sum += (a[i] - a[i - m]);
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}
