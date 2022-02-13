package codingTest.Daliy.작업;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int pre = sc.nextInt();
            int next = sc.nextInt();

            ArrayList<Integer> adjacencyList = list.get(next);
            adjacencyList.add(pre);
        }
        X = sc.nextInt();


        count(X);
        System.out.println(count);
    }

    private static void count(int x) {
        visited[x] = true;
        ArrayList<Integer> adjacencyList = list.get(x);

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[adjacencyList.get(i)]) {
                count++;
                count(adjacencyList.get(i));
            }
        }

    }
}
