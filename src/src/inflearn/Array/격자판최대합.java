package inflearn.Array;

import java.util.Scanner;

public class 격자판최대합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5
//10 13 10 12 15
//12 39 30 23 11
//11 25 50 53 15
//19 27 29 37 27
//19 13 30 13 19
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int countDia = 0;
        for (int i = 0; i < num; i++) {
            int countRow = 0;
            int countCol = 0;
            for (int j = 0; j < num; j++) {
                countRow += arr[i][j];
                countCol += arr[j][i];
                if (i == j) {
                    countDia += arr[i][j];
                }
            }
            if (max < countRow) {
                max = countRow;
            } else if (max < countCol) {
                max = countCol;
            } else if (max < countDia) {
                max = countDia;
            }
        }
        System.out.println(max);

    }
}
