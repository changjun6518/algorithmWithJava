package baekjoon.DFSBFS.숨바꼭질4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int K;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        visited = new boolean[100001];
        parent = new int[100001];
        Stack<Integer> stack = new Stack<>();

        BFS();

        int next = K;
        stack.push(K);
        while (next != N) {
            stack.push(parent[next]);
            next = parent[next];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void BFS() {
        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(N);
        visited[N] = true;
        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            level++;
            for (int i = 0; i < len; i++) {
                Integer now = Q.poll();
                if (now == K) {
                    System.out.println(level-1);
                    return;
                }
                int[] temp = {now + 1, now - 1, now * 2};
                for (int next : temp) {

                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        Q.add(next);
                        parent[next] = now;
                    }
                }
            }
        }
    }


//    public static void DFS(int level) {
//        if (arr[level] == K) {
//            System.out.println(level);
//            for (int i : arr) {
//                System.out.print(i + " ");
//            }
//        } else {
//            int now = arr[level];
//            int[] temp = {now + 1, now - 1, now * 2};
//            for (int i : temp) {
//                if (i >= 0 && i <= 100000 && !visited[i]) {
//                    visited[i] = true;
//                    arr[level + 1] = i;
//                    DFS(level + 1);
//                }
//            }
//        }
//    }
}
