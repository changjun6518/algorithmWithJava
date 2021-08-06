package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대수스케쥴 {
    public static int sum = 0;
    public static int n;
    public static int max = Integer.MIN_VALUE;


    private static class Schedule implements Comparable<Schedule> {
        public int limitDay;
        public int price;

        public Schedule(int limitDay, int price) {
            this.limitDay = limitDay;
            this.price = price;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.limitDay - this.limitDay;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Schedule> schedules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int limitDay = sc.nextInt();
            schedules.add(new Schedule(limitDay, price));
            if (limitDay > max) {
                max = limitDay;
            }
        }
        greedy(schedules);
        System.out.println(sum);

    }

    public static void greedy(ArrayList<Schedule> schedules) {
        Collections.sort(schedules);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (schedules.get(j).limitDay < i) {
                    break;
                }
                pQ.offer(schedules.get(j).price);
            }
            if (!pQ.isEmpty()) {
                sum += pQ.poll();
            }
        }

    }
}
//6
//50 2
//20 1
//40 2
//60 3
//30 3
//30 1