package codingTest.Daliy.트리와쿼리;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] size;
    static boolean[] visited;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();
        edges = new ArrayList[N + 1];
        size = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            edges[start].add(end);
            edges[end].add(start);
        }

        makeTree(R);

        for (int i = 0; i < Q; i++) {
            int q = sc.nextInt();
            System.out.println(size[q]);
        }

    }

    private static void makeTree(int current) {
        visited[current] = true;
        size[current] = 1;
        for (int next : edges[current]) {
            if (!visited[next]) {
                makeTree(next);
                size[current] += size[next];
            }
        }
    }

}
