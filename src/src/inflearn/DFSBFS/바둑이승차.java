package inflearn.DFSBFS;

import java.util.Scanner;

public class 바둑이승차 {
    static int limitWeight, count;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        259 5
//      81
//      58
//      42
//      33
//      61
        limitWeight = sc.nextInt();
        count = sc.nextInt();
        arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, 0);
        System.out.println(answer);
    }

    static public void DFS(int sum, int level) {

        if (limitWeight < sum) {
            return;
        }
        if (level == count) {
            answer = Math.max(sum, answer);
        }
        else {

            if (answer <= sum) {
                answer = sum;
            }
            DFS(sum + arr[level], level + 1);
            DFS(sum, level + 1);
        }
    }
}
