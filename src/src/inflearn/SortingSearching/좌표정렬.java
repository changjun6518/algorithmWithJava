package inflearn.SortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {

    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else return this.x - o.x;
    }
}


public class 좌표정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//5
//2 7
//1 3
//1 2
//2 5
//3 6

        int total = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        Collections.sort(points);
        for (Point point : points) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
