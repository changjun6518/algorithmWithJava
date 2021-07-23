package inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class 부분집합구하기 {
    static int[] arr;
    static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num + 1];

        DFS(1);

    }

    public static void DFS(int L) {
        if (L == num + 1) {
            for (int i = 1; i <= num; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            arr[L] = 1;
            DFS(L+1);
            arr[L] = 0;
            DFS(L+1);
        }
    }


}
