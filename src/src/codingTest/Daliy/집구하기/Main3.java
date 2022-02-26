package codingTest.Daliy.집구하기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main3 {
    static int N;
    static ArrayList<Pair>[] graph;
    static PriorityQueue<Pair> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph[start].add(new Pair(end, cost));
            graph[end].add(new Pair(start, cost));
        }

        int[] mac_dist = new int[N+1];
        for(int i=0; i<=N; i++)
            mac_dist[i] = Integer.MAX_VALUE;

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int mac_min = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            int mac = Integer.parseInt(input[i]);
            mac_dist[mac] = 0;
            queue.add(new Pair(mac, 0));
        }

        dijkstra(mac_dist);

        int[] star_dist = new int[N+1];
        for(int i=0; i<=N; i++)
            star_dist[i] = Integer.MAX_VALUE;

        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int star_min = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            int star = Integer.parseInt(input[i]);
            star_dist[star] = 0;
            queue.add(new Pair(star, 0));
        }

        dijkstra(star_dist);

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            if(mac_dist[i]>0 && mac_dist[i]<=mac_min && star_dist[i]<=star_min && star_dist[i]>0)
                ans = Math.min(ans, mac_dist[i]+star_dist[i]);
        }

        if(ans==Integer.MAX_VALUE)
            System.out.println(-1);

        else
            System.out.println(ans);
    }

    public static void dijkstra(int[] distance) {

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();

            for (int i = 0; i < graph[temp.end].size(); i++) {
                Pair p = graph[temp.end].get(i);

                if (distance[p.end] > p.cost + temp.cost) {
                    queue.add(new Pair(p.end, temp.cost + p.cost));
                    distance[p.end] = temp.cost + p.cost;
                }
            }
        }
    }

    public static class Pair implements Comparable<Pair>{
        int end;
        int cost;

        public Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Pair p) {

            return this.cost > p.cost ? 1 : -1;
        }
    }
}
