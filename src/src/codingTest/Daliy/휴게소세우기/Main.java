package codingTest.Daliy.휴게소세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> rest;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        rest = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rest.add(Integer.parseInt(st.nextToken()));
        }
        rest.add(0);
        rest.add(L);
        Collections.sort(rest);

        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static boolean possible(int mid) {
        int count = 0;
        for (int i = 1; i < rest.size(); i++) {
            count += (rest.get(i) - rest.get(i - 1) - 1) / mid;
        }
        return count > M;
    }
}
