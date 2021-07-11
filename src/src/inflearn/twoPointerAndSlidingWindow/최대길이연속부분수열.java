package inflearn.twoPointerAndSlidingWindow;

import java.util.Scanner;

public class 최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        14 2
//1 1 0 0 1 1 0 1 1 0 1 1 0 1
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt]==0) cnt++;
            while (cnt > m) {
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);
    }
}
