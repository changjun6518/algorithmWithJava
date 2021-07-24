package inflearn.RecursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 그래프최단거리 {
    static int vertex, edge, answer = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] check, dis;

    public static int BFS(int target, int ver) {
        LinkedList<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.offer(ver);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer currentVertex = queue.poll();
                if (currentVertex == target) {
                    for (int j = 2; j <= vertex; j++) {
                        check[j] = 0;
                    }
                    return level;
                }
                for (Integer nextVertexs : graph.get(currentVertex)) {
                    if (check[nextVertexs] == 0) {
                        check[nextVertexs] = 1;
                        queue.offer(nextVertexs);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void BFS2(int ver) {
        LinkedList<Integer> queue = new LinkedList<>();
        check[ver] = 1;
        dis[ver] = 0;
        queue.offer(ver);
        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            for (Integer nextVertex : graph.get(currentVertex)) {
                if (check[nextVertex] == 0) {
                    check[nextVertex] = 1;
                    queue.offer(nextVertex);
                    dis[nextVertex] = dis[currentVertex] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt();
        edge = sc.nextInt();

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }
        check = new int[vertex + 1];
        dis = new int[vertex + 1];
        for (int i = 0; i < edge; i++) {
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            graph.get(startVertex).add(endVertex);
        }
        check[1] = 1;

//        for (int i = 2; i <= vertex; i++) {
//            System.out.println(i + " : " + BFS(i, 1));
//        }

        BFS2(1);
        for (int i = 2; i <= vertex; i++) {
            System.out.println(i + " : " + dis[i]);
        }

    }
}
//6 9
//1 3
//1 4
//2 1
//2 5
//3 4
//4 5
//4 6
//6 2
//6 5
