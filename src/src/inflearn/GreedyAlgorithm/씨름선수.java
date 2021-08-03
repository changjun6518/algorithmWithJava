package inflearn.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 씨름선수 {
    public static int count = 0;
    private static class Point implements Comparable<Point> {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.x - this.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(players);
        greedy(players);

        System.out.println(count);
    }

    public static void greedy(ArrayList<Point> players) {
        int max = Integer.MIN_VALUE;
        for (Point player : players) {
            if (max < player.y) {
                count++;
                max = player.y;
            }
        }
    }
}
//5
//172 67
//183 65
//180 70
//170 72
//181 60