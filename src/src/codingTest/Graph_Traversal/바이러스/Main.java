package codingTest.Graph_Traversal.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] adjacencyList;
    public static int totalCount;
    public static int connectCount;
    public static boolean[] visited;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        totalCount = Integer.parseInt(br.readLine());
        connectCount = Integer.parseInt(br.readLine());
        adjacencyList = new ArrayList[totalCount + 1];
        visited = new boolean[totalCount + 1];

        for (int i = 1; i <= totalCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        bfs();

        System.out.println(count);
    }

    public static void bfs() {
        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(1);
        visited[1] = true;

        while (!Q.isEmpty()) {
            Integer now = Q.pop();
            ArrayList<Integer> nowList = adjacencyList[now];
            for (Integer index : nowList) {
                if (!visited[index]) {
                    visited[index] = true;
                    Q.add(index);
                    count++;
                }
            }
        }
    }
}
