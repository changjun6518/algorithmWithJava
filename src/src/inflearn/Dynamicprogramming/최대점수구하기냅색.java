package inflearn.Dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 최대점수구하기냅색 {
    static int[] dy;
    static int n, m;

    private static class problem implements Comparable<problem>{
        public int score;
        public int time;

        public problem(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(problem o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dy = new int[m + 1];
        ArrayList<problem> problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            problems.add(new problem(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println(solution(problems));

    }

    public static int solution(ArrayList<problem> problems) {
        Collections.sort(problems);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            problem problem = problems.get(i);
            for (int j = m; j >= problem.time; j--) {
                dy[j] = Math.max(dy[j], dy[j - problem.time] + problem.score);
            }
        }
        return dy[m];
    }
}
//5 20
//10 5
//25 12
//15 8
//6 3
//7 4