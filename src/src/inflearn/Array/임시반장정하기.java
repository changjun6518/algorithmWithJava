package inflearn.Array;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][5];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int answer = 0;
        for (int i = 0; i < num; i++) {
            int cnt = 0;
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i+1;
            }
        }
        System.out.println(answer);

    }
}
