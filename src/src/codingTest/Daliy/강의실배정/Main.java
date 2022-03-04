package codingTest.Daliy.강의실배정;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = sc.nextInt();
        Time[] times = new Time[N];

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            times[i] = new Time(S, E);
        }
        Arrays.sort(times);

        pq.offer(times[0].end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= times[i].start) {
                pq.poll();
            }
            pq.offer(times[i].end);
        }


        System.out.println(pq.size());
    }

    private static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (start == o.start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
}
