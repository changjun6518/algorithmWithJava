package inflearn.DFSBFS;

import java.util.Scanner;

public class 합이같은부분집합 {

    static String answer = "NO";
    static int totalSum = 0;
    static int numberCount;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        6
//1 3 5 6 7 10
        numberCount = sc.nextInt();
        int[] arr = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        DFS(arr, 0, 0);
        System.out.println(answer);


    }

    public static void DFS(int[] arr, int sum, int level) {
        if (flag) {
            return;
        }
        if (level == numberCount) {
            if ((totalSum - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(arr, sum + arr[level], level + 1);
            DFS(arr, sum, level + 1);
        }
    }

}
