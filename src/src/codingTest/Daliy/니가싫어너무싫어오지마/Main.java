package codingTest.Daliy.니가싫어너무싫어오지마;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Time[] times = new Time[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        Arrays.sort(times);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(times[0].end);
        int count = 1;
        int start = times[0].start;
        int end = times[0].end;

        for (int i = 1; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() < times[i].start) {
                pq.poll();
            }
            if (!pq.isEmpty() && pq.peek() == times[i].start) {
                if (pq.peek() == end) {
                    end = times[i].end;
                }
                pq.poll();
            }

            pq.add(times[i].end);
            if (pq.size() > count) {
                count = pq.size();
                start = times[i].start;
                end = pq.peek();
            }
        }
        System.out.println(count);
        System.out.println(start + " " + end);

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
