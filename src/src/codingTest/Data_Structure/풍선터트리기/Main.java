package codingTest.Data_Structure.풍선터트리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<int[]> Q = new ArrayDeque<>();

        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }
        for (int i = 1; i < len; i++) {
            Q.add(new int[]{(i + 1), arr[i]});
        }

        sb.append(1).append(" ");
        int next = arr[0];
        int[] now;
        while (!Q.isEmpty()) {
            if (next > 0) {
                for (int i = 1; i < next; i++) {
                    Q.add(Q.pollFirst());
                }
                now = Q.removeFirst();
                sb.append(now[0]).append(" ");
                next = now[1];
            } else {
                for (int i = 0; i < -next; i++) {
                    Q.addFirst(Q.pollLast());
                }
                now = Q.removeFirst();
                sb.append(now[0]).append(" ");
                next = now[1];
            }
        }

        System.out.println(sb.toString());
    }
}
