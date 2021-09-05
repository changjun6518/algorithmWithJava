package baekjoon.DFSBFS.숨바꼭질2;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int K;
    static boolean visited[] = new boolean[100001];
    static int cnt[] = new int[100001];
    static int dist[] = new int[100001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(N);
        visited[N] = true;
        cnt[N] = 1;
        while (!Q.isEmpty()) {
            int now = Q.poll();
            int[] next = {now - 1, now + 1, now * 2};
            for (int n : next) {
                if (n >= 0 && n <= 100000) {
                    if (!visited[n]) {
                        visited[n] = true;
                        dist[n] = dist[now] + 1;
                        Q.add(n);
                        cnt[n] = cnt[now];
                    }
                    else if (dist[n] == dist[now] + 1) {
                        cnt[n] += cnt[now];
                    }
                }
            }
        }
        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }
}
