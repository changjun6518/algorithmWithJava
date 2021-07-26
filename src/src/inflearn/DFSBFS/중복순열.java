package inflearn.DFSBFS;

import java.util.Scanner;

public class 중복순열 {
    static int totalCount;
    static int limitNum;
    static int[] arr;
    static int[] purmutation;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //3 2
        totalCount = sc.nextInt();
        limitNum = sc.nextInt();

        arr = new int[totalCount];
        purmutation = new int[limitNum];
        for (int i = 0; i < totalCount; i++) {
            arr[i] = i + 1;
        }
        DFS(0);

    }

    public static void DFS(int level) {
        if (level == limitNum) {
            for (int i : purmutation) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= totalCount; i++) {
                purmutation[level] = i;
                DFS(level + 1);
            }
        }
    }
}

