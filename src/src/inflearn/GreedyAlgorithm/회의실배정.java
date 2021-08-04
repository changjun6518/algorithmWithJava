package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 회의실배정 {
    public static int count = 1;
    private static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            times.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(times);
        greedy(times);
        System.out.println(count);
    }

    public static void greedy(ArrayList<Point> times) {
        int i = 1;
        Point init = times.get(0);

        while (i != times.size()) {
            if (init.y <= times.get(i).x) {
                count++;
                init = times.get(i);
            }
            i++;
        }
    }


}
//5
//1 4
//2 3
//3 5
//4 6
//5 7