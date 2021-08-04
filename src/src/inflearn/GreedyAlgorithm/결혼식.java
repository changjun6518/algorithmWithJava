package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 결혼식 {

    private static class Time implements Comparable<Time> {
        public char state;
        public int time;

        public Time(char state, int time) {
            this.state = state;
            this.time = time;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                return this.state - o.state;
            }
            return this.time - o.time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Time> times = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            times.add(new Time('s', sc.nextInt()));
            times.add(new Time('e', sc.nextInt()));
        }

        Collections.sort(times);
        greedy(times);

        System.out.println(answer);
    }

    public static int answer = 0;
    public static void greedy(ArrayList<Time> times) {
        int cnt = 0;
        for (Time time : times) {
            if (time.state == 'e') {
                cnt--;
            }
            if (time.state == 's') {
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
    }
}
//5
//14 18
//12 15
//15 20
//20 30
//5 14