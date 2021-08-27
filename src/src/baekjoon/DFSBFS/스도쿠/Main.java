package baekjoon.DFSBFS.스도쿠;

import java.util.Scanner;

public class Main {
    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = scanner.nextInt();
            }
        }

        DFS(0, 0);

    }

    public static void DFS(int x, int y) {
        if (y == 9) {
            DFS(x+1,0);
            return;
        }

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);

        }

        if (sudoku[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkRowCol(x, y, i) && checkBox(x, y, i)) {
                    sudoku[x][y] = i;
                    DFS(x, y + 1);
                }
            }
            sudoku[x][y] = 0;
            return;
        }

        DFS(x, y + 1);
    }

    public static boolean checkRowCol(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
            if (sudoku[i][col] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkBox(int row, int col, int value) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
