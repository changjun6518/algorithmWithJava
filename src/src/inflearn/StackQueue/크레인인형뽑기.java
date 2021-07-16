package inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardSizeNum = sc.nextInt();

        int[][] board = new int[boardSizeNum][boardSizeNum];

        for (int i = 0; i < boardSizeNum; i++) {
            for (int j = 0; j < boardSizeNum; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int movesSizeNum = sc.nextInt();
        int[] moves = new int[movesSizeNum];
        for (int i = 0; i < movesSizeNum; i++) {
            moves[i] = sc.nextInt();
        }

        Stack<Integer> basket = new Stack<Integer>();
        int count = 0;
        for (int move : moves) {
            int doll = pickDoll(move, boardSizeNum, board);
            if (basket.isEmpty()){
                basket.push(doll);
                continue;
            }
            if (doll == -1) {
                continue;
            }
            if (basket.peek() != doll) {
                basket.push(doll);
                continue;
            }
            if (basket.peek() == doll) {
                basket.pop();
                count += 2;
            }
        }

        System.out.println(count);

    }

    public static int pickDoll(int move, int boardSizeNum, int[][] board) {
        int doll = 0;
        for (int i = 0; i < boardSizeNum; i++) {
            if (board[i][move - 1] == 0) {
                continue;
            }
            doll = board[i][move - 1];
            board[i][move - 1] = 0;
            return doll;
        }
        return -1;
    }
}
