package baekjoon.DFSBFS.스타트링크;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static Boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        F = scanner.nextInt();
        S = scanner.nextInt();
        G = scanner.nextInt();
        U = scanner.nextInt();
        D = scanner.nextInt();
        visited = new Boolean[F + 1];
        Arrays.fill(visited, false);
        int result = BFS();
        if (result == -1) {
            System.out.print("use the stairs");
        } else {
            System.out.println(result);
        }
    }


    public static int BFS() {
        LinkedList<Integer> queue = new LinkedList<>();
        int level = 0;
        int len;
        visited[S] = true;
        queue.add(S);
        while (!queue.isEmpty()) {
            len = queue.size();
            level++;
            for (int i = 0; i < len; i++) {
                Integer now = queue.poll();
                if (now == G) {
                    return level-1;
                }
                if (now + U <= F && !visited[now + U]) {
                    visited[now + U] = true;
                    queue.add(now + U);
                }
                if (now - D >= 1 && !visited[now - D]) {
                    visited[now - D] = true;
                    queue.add(now - D);
                }
            }
        }
        return -1;

    }
}
