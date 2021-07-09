package inflearn.Array;

import java.util.Scanner;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num + 2][num + 2];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int answer = 0;

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (arr[i][j] < arr[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        System.out.println(answer);


//        System.out.println(count(arr, num));


    }

    public static int count(int[][] arr, int num) {
        int count = 0;
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                int now = arr[i][j];
                if (arr[i - 1][j] < now && arr[i + 1][j] < now && arr[i][j + 1] < now && arr[i][j - 1] < now) {
                    count++;
                }

            }
        }
        return count;
    }


}
