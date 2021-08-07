package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 원더랜드 {
    public static int[] unf;
    public static int sum = 0;
    private static class Edge implements Comparable<Edge> {
        public int startNode;
        public int endNode;
        public int cost;

        public Edge(int startNode, int endNode, int cost) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    public static int find(int v) {
        if(unf[v] == v) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void minSpanningTree(ArrayList<Edge> graph) {
        Collections.sort(graph);
        for (Edge edge : graph) {
            int fa = find(edge.startNode);
            int fb = find(edge.endNode);
            if (fa != fb) {
                union(edge.startNode, edge.endNode);
                sum += edge.cost;
            }
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
        ArrayList<Edge> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            graph.add(new Edge(start, end, cost));
        }

        minSpanningTree(graph);

        System.out.println(sum);
    }
}
//9 12
//1 2 12
//1 9 25
//2 3 10
//2 8 17
//2 9 8
//3 4 18
//3 7 55
//4 5 44
//5 6 60
//5 7 38
//7 8 35
//8 9 15