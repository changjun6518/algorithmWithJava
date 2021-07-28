package inflearn.DFSBFS;

import java.util.Scanner;

public class 조합구하기 {
    static int[] combi;
    static int n, r;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        combi = new int[r];
        DFS(0, 1);

    }

    public static void DFS(int level, int index) {
        if (level == r) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = index; i <= n; i++) {
                combi[level] = i;
                DFS(level+1, i+1);
            }
        }
    }
}
