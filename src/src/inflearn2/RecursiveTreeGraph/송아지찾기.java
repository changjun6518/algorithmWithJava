package inflearn2.RecursiveTreeGraph;

import java.util.LinkedList;
import java.util.Scanner;

public class 송아지찾기 {
    static int n, m;
    static int[] direct = {-1, 1, 5};
    static int ch[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        System.out.println(solution(n, m));
    }

    private static int solution(int n, int m) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        ch = new int[10001];
        ch[n] = 1;
        queue.add(n);
        int level = 0;
        int len = 0;
        while (!queue.isEmpty()) {
            len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer now = queue.poll();
                if (now == m) {
                    return level;
                }
                for (int j = 0; j < 3; j++) {
                    int nx = now + direct[j];
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.add(nx);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
