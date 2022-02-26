package codingTest.Daliy.집구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Dijkstra dijkstra = new Dijkstra(v, e);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            dijkstra.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int mcSize = Integer.parseInt(st.nextToken());
        int mcLimit = Integer.parseInt(st.nextToken());
        ArrayList<Integer> mcList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mcSize; i++) {
            mcList.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int starSize = Integer.parseInt(st.nextToken());
        int starLimit = Integer.parseInt(st.nextToken());
        ArrayList<Integer> starList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < starSize; i++) {
            starList.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> houses = new ArrayList<>();
        for (int i = 1; i <= v; i++) {
            houses.add(i);
        }
        houses.removeAll(mcList);
        houses.removeAll(starList);

        for (Integer houseIndex : houses) {
            dijkstra.run(houseIndex);
            dijkstra.calculateResult(mcList, mcLimit, starList, starLimit);
        }
        int answer = dijkstra.answer;
        answer = (answer > 10000) ? -1 : answer;
        System.out.println(answer);

    }

    private static class Dijkstra {
        int V;
        int E;
        List<List<Point>> graph = new ArrayList<>();
        int[] distance;
        boolean[] visited;
        int answer = 10001;

        public Dijkstra(int v, int e) {
            V = v;
            E = e;
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void addEdge(int start, int end, int value) {
            graph.get(start).add(new Point(end, value));
            graph.get(end).add(new Point(start, value));
        }

        public void run(int start) {
            PriorityQueue<Point> pq = new PriorityQueue<>();
            distance = new int[V + 1];
            visited = new boolean[V + 1];
            Arrays.fill(distance, 10001);
            pq.add(new Point(start, 0));
            visited[start] = true;

            while (!pq.isEmpty()) {
                Point point = pq.poll();
                int nowIndex = point.index;
                int value = point.value;

//                if (value > distance[nowIndex]) continue;

                for (Point nextPoint : graph.get(nowIndex)) {
                    if (!visited[nextPoint.index] && value + nextPoint.value < distance[nextPoint.index]) {
                        distance[nextPoint.index] = value + nextPoint.value;
                        pq.offer(new Point(nextPoint.index, distance[nextPoint.index]));
                    }
                }
                visited[nowIndex] = true;
            }
        }

        public void calculateResult(ArrayList<Integer> mcList, int mcLimit, ArrayList<Integer> starList, int starLimit) {
            int mc = checkValid(mcList, mcLimit);
            int star = checkValid(starList, starLimit);
            answer = Math.min(answer, mc + star);
        }

        private int checkValid(ArrayList<Integer> list, int limit) {
            int min = 10001;
            for (Integer index : list) {
                if (distance[index] <= limit && distance[index] < min) {
                    min = distance[index];
                }
            }
            return min;
        }

    }

    private static class Point implements Comparable<Point>{
        int index;
        int value;

        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(value, o.value);
        }
    }
}
