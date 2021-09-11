package programmers.풀었던것.라인;

import java.util.ArrayList;
import java.util.Scanner;

public class MainOne {
    static int count = 0;
    static int k;
    static int[] dx = {-1, 1};
    static int answer = 0;
    static ArrayList<Integer> stu = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = 1;
        int[] student = {0, 1, 0};
        System.out.println(solution(student, k));
    }

    public static int solution(int[] student, int k) {
        //  한개의 그룹을 만듬
        //  재학생 k명이 포함되어야 함
        //  신입생은 노상관
        //
        boolean[] visited = new boolean[student.length];

        for (int i = 1; i < student.length; i++) {
//            DFS(0, i, k, student, visited);
        }

        return answer;
    }

}