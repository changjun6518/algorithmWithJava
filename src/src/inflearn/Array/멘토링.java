package inflearn.Array;

import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        4 3
//       3 4 1 2
//       4 3 2 1
//       3 1 4 2
        int stuNum = sc.nextInt();
        int testNum = sc.nextInt();

        int[][] arr = new int[testNum][stuNum];
        for (int i = 0; i < testNum; i++) {
            for (int j = 0; j < stuNum; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = 0;

        for (int i = 1; i <= stuNum; i++) {
            for (int j = 1; j <= stuNum; j++) {
                int pi = 0;
                int pj = 0;
                int count = 0;
                for (int k = 0; k < testNum; k++) {
                    for (int l = 0; l < stuNum; l++) {
                        if (arr[k][l] == i) {
                            pi = l;
                        }
                        if (arr[k][l] == j) {
                            pj = l;
                        }
                    }
                    if (pi < pj) {
                        count++;
                    }
                }
                if (count == testNum) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
