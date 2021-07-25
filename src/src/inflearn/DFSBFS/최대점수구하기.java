package inflearn.DFSBFS;

import java.util.HashMap;
import java.util.Scanner;

public class 최대점수구하기 {
    static int answer = 0, timeLimit, problemCount;
    static int[] timeToSolve, scoreByProblem;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        problemCount = sc.nextInt();
        timeLimit = sc.nextInt();
        timeToSolve = new int[problemCount];
        scoreByProblem = new int[problemCount];

        for (int i = 0; i < problemCount; i++) {
            scoreByProblem[i] = sc.nextInt();
            timeToSolve[i] = sc.nextInt();
        }
        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int timeSum, int scoreSum, int level) {
        if (timeSum > timeLimit) {
            return;
        }
        if (problemCount == level) {
            answer = Math.max(scoreSum, answer);
        } else {
            DFS(timeSum + timeToSolve[level], scoreSum + scoreByProblem[level], level + 1);
            DFS(timeSum, scoreSum, level + 1);

        }

    }

//    5 20
//10 5
//25 12
//15 8
//6 3
//7 4
}
