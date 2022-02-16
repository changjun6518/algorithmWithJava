package codingTest.Daliy.숨바꼭질;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int K;
    static int N;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new int[100001];

        System.out.println(bfs());
    }

    public static int bfs() {
        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(N);
        visited[N] = 0;
        int[] next = new int[3];
        while (!Q.isEmpty()) {
            Integer now = Q.pop();
            if (now == K) {
                return visited[K];
            }

            next[0] = now - 1;
            next[1] = now + 1;
            next[2] = now * 2;

            for (int i = 0; i < 3; i++) {
                if(next[i]<0 ||next[i]>100000) continue;

                if (visited[next[i]] != 0) continue;

                visited[next[i]] = visited[now] + 1;
                Q.add(next[i]);
            }
        }
        return visited[K];
    }

}
