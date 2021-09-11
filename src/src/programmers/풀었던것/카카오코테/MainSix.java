package programmers.풀었던것.카카오코테;

import java.util.Arrays;

public class MainSix {


    public static void main(String[] args) {

        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        System.out.println(solution(board, skill));
    }



    public static int solution(int[][] board, int[][] skills) {
        //  skill = type, r1, c1, r2, c2, degree

        for (int[] skill : skills) {
            System.out.println(Arrays.toString(skill));

            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];
            if (type == 1) {
                // 공격
                for (int j = r1; j <= r2; j++) {
                    for (int k = c1; k <= c2; k++) {
                        board[j][k] -= degree;
                    }
                }
            } else {
                for (int j = r1; j <= r2; j++) {
                    for (int k = c1; k <= c2; k++) {
                        board[j][k] += degree;
                    }
                }
            }
        }


        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
