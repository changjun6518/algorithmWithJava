package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 원더랜드2 {
    public static int[] unf;
    public static int sum = 0;
    private static class Edge implements Comparable<Edge> {
        public int nextNode;
        public int cost;

        public Edge(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ch = new int[n + 1];

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            graph.get(start).add(new Edge(end, cost));
            graph.get(end).add(new Edge(start, cost));
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.nextNode;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                sum += tmp.cost;
                for (Edge edge : graph.get(ev)) {
                    if (ch[edge.nextNode] == 0) {
                        pQ.offer(new Edge(edge.nextNode, edge.cost));
                    }
                }
            }
        }
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