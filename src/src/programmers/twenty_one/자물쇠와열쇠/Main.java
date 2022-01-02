package programmers.twenty_one.자물쇠와열쇠;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] key = new int[N][N];
        int[][] lock = new int[M][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                key[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                lock[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(key, lock));
    }
    public static boolean solution(int[][] key, int[][] lock) {
        int keyLen = key.length;
        int lockLen = lock.length;
        int gap = keyLen - 1;

        for (int i = 0; i < lockLen + gap; i++) {
            for (int j = 0; j < lockLen + gap; j++) {
                for (int k = 0; k < 4; k++) {
                    int[][] newLock = new int[lockLen + gap * 2][lockLen + gap * 2];

                    for (int x = 0; x < lockLen; x++) {
                        for (int y = 0; y < lockLen; y++) {
                            newLock[x + gap][y + gap] = lock[x][y];
                        }
                    }

                    merge(newLock, key, i, j, k);

                    if (check(newLock, gap, lockLen)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static void merge(int[][] newLock, int[][] key, int x, int y, int rota) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (rota == 0) {
                    newLock[i + x][j + y] += key[i][j];
                } else if (rota == 1) {
                    newLock[i + x][j + y] += key[j][key.length - i - 1];
                } else if (rota == 2) {
                    newLock[i + x][j + y] += key[key.length - i - 1][key.length - j - 1];
                } else {
                    newLock[i + x][j + y] += key[key.length - j - 1][i];
                }
            }
        }
    }

    public static boolean check(int[][] newLock, int gap, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (newLock[i + gap][j + gap] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
