package programmers.블록이동하기;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static int solution(int[][] board) {
        //  2x1 크기 로봇   ->  클래스 로봇
        //  0은 빈칸, 1은 벽
        // (N,N)위치로 이동
        //  시작은 가로방향으로 놓여있는 상태
        //  90도 회전이 가능하지만 대각선에 벽이 있으면 불가능 ->    회전 함수
        //  한번 회전에 1초   ->  BFS
        //  방문 여부       ->  visited[][][][]
        // 최소 시간을 return
        return 1;
    }

    public static void BFS(int N) {
        LinkedList<Robot> Q = new LinkedList<>();
        Q.add(new Robot(1, 1, 1, 2));
        boolean[][][][] visited = new boolean[N + 1][N + 1][N + 1][N + 1];
        visited[1][1][1][2] = true;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < 4; i++) {
                Robot now = Q.poll();
//                rotate(now, i);
            }
        }
    }

    //  1,1     1,2     1,3
    //  2,1     2,2     2,3     2,4
    //  3,1     3,2     3,3     3,4
    private static void rotate(Robot now, int stand, int leftRight) {
        // a 기준 왼쪽회전


    }

    private static class Robot {
        int ax;
        int ay;
        int bx;
        int by;

        public Robot(int ax, int ay, int bx, int by) {
            this.ax = ax;
            this.ay = ay;
            this.bx = bx;
            this.by = by;
        }
    }

}
