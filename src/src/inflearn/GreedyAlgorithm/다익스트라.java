package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라 {
    public static int n;
    public static int m;
    public static int[] dis;
    public static ArrayList<ArrayList<Edge>> graph;

    private static class Edge implements Comparable<Edge> {
        public int vex;
        public int cost;
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dis = new int[n + 1];
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            int index = scanner.nextInt();
            int ver = scanner.nextInt();
            int cos = scanner.nextInt();

            graph.get(index).add(new Edge(ver, cos));
        }
        for (int i = 0; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        solution(1);

        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else System.out.println(i + " : impossible");
        }
    }

    public static void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge temp = pQ.poll();
            int now = temp.vex;
            int cost = temp.cost;
            if (dis[now] < cost) {
                continue;
            }
            for (Edge edge : graph.get(now)) {
                if (edge.cost + cost < dis[edge.vex]) {
                    dis[edge.vex] = edge.cost + cost;
                    pQ.offer(new Edge(edge.vex, edge.cost + cost));
                }
            }
        }
    }
}
