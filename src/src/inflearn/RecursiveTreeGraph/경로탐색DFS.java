package inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class 경로탐색DFS {
    static int[][] graph;
    static int[] ch;
    static int nodeNum, edgeNum, answer = 0;
    public static void DFS(int v) {
        if (v == nodeNum) {
            answer++;
        } else {
            for (int i = 1; i < nodeNum + 1; i++) {
                if (ch[i] == 0 && graph[v][i] == 1) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nodeNum = sc.nextInt();
        edgeNum = sc.nextInt();
        graph = new int[nodeNum + 1][nodeNum + 1];
        ch = new int[nodeNum + 1];

        for (int i = 0; i < edgeNum; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            graph[startNode][endNode] = 1;
        }
        ch[1] = 1;
        DFS(1);

        System.out.println(answer);

    }
}
