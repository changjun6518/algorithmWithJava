package inflearn.DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리 {
    public static int n;
    public static int m, pizzaHouseLength;
    public static int[] combi;
    public static ArrayList<Point> pizzaHouses = new ArrayList<>();
    public static ArrayList<Point> houses = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;

    public static void DFS(int level, int index) {
        if (level == m) {
            int sum = 0;
            for (Point house : houses) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(house.x - pizzaHouses.get(i).x) + Math.abs(house.y - pizzaHouses.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = index; i < pizzaHouseLength; i++) {
                combi[level] = i;
                DFS(level + 1, i + 1);
            }
        } 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    houses.add(new Point(i, j));
                } else if (tmp == 2) {
                    pizzaHouses.add(new Point(i, j));
                }
            }
        }

        pizzaHouseLength = pizzaHouses.size();

        DFS(0,0);
        System.out.println(answer);
    }
}

//4 4
//0 1 2 0
//1 0 2 1
//0 2 1 2
//2 0 1 2