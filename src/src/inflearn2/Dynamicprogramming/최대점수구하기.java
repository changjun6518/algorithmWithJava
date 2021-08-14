package inflearn2.Dynamicprogramming;

import inflearn.Dynamicprogramming.최대점수구하기냅색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 최대점수구하기 {
    static int[] dy;
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dy = new int[m + 1];
        ArrayList<최대점수구하기냅색.problem> problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            problems.add(new 최대점수구하기냅색.problem(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println(solution(problems));

    }

    public static int solution(ArrayList<최대점수구하기냅색.problem> problems) {
        Collections.sort(problems);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            최대점수구하기냅색.problem problem = problems.get(i);
            for (int j = m; j >= problem.time; j--) {
                dy[j] = Math.max(dy[j - problem.time] + problem.score, dy[j]);
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