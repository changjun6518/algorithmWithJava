package inflearn.RecursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    int[] dis = {-1, 1, 5};
    int[] ch;
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer x = queue.poll();
                if (x == e) {
                    return L;
                }
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx > 1 && nx < 10001 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();

        송아지찾기 temp = new 송아지찾기();
        System.out.println(temp.BFS(S, E));

    }

}