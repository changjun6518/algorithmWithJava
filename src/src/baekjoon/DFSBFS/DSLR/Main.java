package baekjoon.DFSBFS.DSLR;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static String[] command = new String[10000];
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            Arrays.fill(command, "");
            Arrays.fill(visited, false);
            BFS(scanner.nextInt(), scanner.nextInt());
        }

    }

    static void BFS(int pro, int ans) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(pro);
        visited[pro] = true;
        while (!queue.isEmpty() && !visited[ans]) {
            int now = queue.poll();
            int D = (2 * now) % 10000;
            int S = (now == 0) ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }
            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }
            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }
            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }

        }
        System.out.println(command[ans]);
    }
}
