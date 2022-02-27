package codingTest.Daliy.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> Q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (!Q.contains(left) && !Q.contains(right)) {
                Q.add(left);
                Q.add(right);
            } else if (Q.contains(left)) {
                Q.addLast(right);
            } else if (Q.contains(right)) {
                Q.addFirst(left);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!Q.contains(i)) {
                Q.add(i);
            }
        }

        String collect = Q.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
