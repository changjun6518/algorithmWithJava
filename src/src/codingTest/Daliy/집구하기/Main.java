package codingTest.Daliy.집구하기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int V;
    static int E;
    static int[][] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        graph = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                graph[i][j] = 10001;
            }
            graph[i][i] = 0;
        }
        for (int i = 0; i < E; i++) {
            fill(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        int mc = sc.nextInt();
        int mcLimit = sc.nextInt();
        ArrayList<Integer> mcList = new ArrayList<>();
        for (int i = 0; i < mc; i++) {
            mcList.add(sc.nextInt());
        }
        int star = sc.nextInt();
        int starLimit = sc.nextInt();
        ArrayList<Integer> starList = new ArrayList<>();
        for (int i = 0; i < star; i++) {
            starList.add(sc.nextInt());
        }

        ArrayList<Integer> houseList = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            houseList.add(i);
        }
        houseList.removeAll(mcList);
        houseList.removeAll(starList);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < houseList.size(); i++) {
            Integer startHouse = houseList.get(i);
            dijkstra(startHouse);
            int minStarDistance = getMinDistance(starList, starLimit);
            int minMcDistance = getMinDistance(mcList, mcLimit);

            min = Math.min(min, minMcDistance + minStarDistance);
        }

        min = (min > 10000) ? -1 : min;
        System.out.println(min);
    }

    public static int getMinDistance(ArrayList<Integer> list, int limit) {
        int min = 10001;
        for (Integer star : list) {
            if (distance[star] <= limit && distance[star] < min) {
                min = distance[star];
            }
        }
        return min;
    }

    public static void dijkstra(int start) {
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            distance[i] = graph[start][i];
        }
        visited[start] = true;

        for (int i = 0; i < V - 2; i++) {
            int current = getSmallIndex();
            visited[current] = true;
            for (int j = 1; j <= V; j++) {
                if (!visited[j]) {
                    if (distance[current] + graph[current][j] < distance[j]) {
                        distance[j] = distance[current] + graph[current][j];
                    }
                }
            }
        }
    }

    public static void fill(int from, int to, int value) {
        graph[from][to] = value;
        graph[to][from] = value;
    }

    public static int getSmallIndex() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= V; i++) {
            if (distance[i] < min && !visited[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }
}
