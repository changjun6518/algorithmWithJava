package inflearn.RecursiveTreeGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색인접리스트 {
    static int vertex, edge, answer = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] check;

    public static void DFS(int ver) {
        if (ver == vertex) {
            answer++;
        } else {
            for (Integer nextVertex : graph.get(ver)) {
                if (check[nextVertex] == 0) {
                    check[nextVertex] = 1;
                    DFS(nextVertex);
                    check[nextVertex] = 0;
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

        for (int i = 0; i < edge; i++) {
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            graph.get(startVertex).add(endVertex);
        }
        check[1] = 1;
        DFS(1);
        System.out.println(answer);
    }


}
//5 9
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 4
//4 2
//4 5