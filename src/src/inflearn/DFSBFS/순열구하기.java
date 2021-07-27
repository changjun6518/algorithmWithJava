package inflearn.DFSBFS;

import java.util.Scanner;

public class 순열구하기 {
    static int n;
    static int r;
    static int[] arr;
    static int[] check;
    static int[] print;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  3 2
        // 3 6 9
        n = sc.nextInt();
        r = sc.nextInt();
        arr = new int[n];
        check = new int[n];
        print = new int[r];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0);
    }

    public static void DFS(int level) {
        if (level == r) {
            for (int i : print) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    print[level] = arr[i];
                    DFS(level+1);
                    check[i] = 0;
                }
            }
        }
    }
}
