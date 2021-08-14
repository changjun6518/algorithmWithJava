package inflearn2.GreedyAlgorithm;

import java.util.Scanner;

public class 친구인가 {
    public static int[] unf;
    public static int find(int v) {
        if (unf[v] == v) {
            return unf[v];
        } else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            union(scanner.nextInt(), scanner.nextInt());
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            System.out.println("YES");
        }else System.out.println("NO");

    }
}
//9 7
//1 2
//2 3
//3 4
//1 5
//6 7
//7 8
//8 9
//3 8

