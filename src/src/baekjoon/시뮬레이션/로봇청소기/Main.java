package baekjoon.시뮬레이션.로봇청소기;

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        Robot robot = new Robot(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        solution(robot);

        System.out.println(answer);
    }

    public static void solution(Robot robot) {
        // 1. 현재 위치를 청소
        if (arr[robot.x][robot.y] == 0 && !visited[robot.x][robot.y]) {
            answer++;
            visited[robot.x][robot.y] = true;
        }
        int count = 0;
        while (true) {
            // 2. a 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면 회전 + 한칸 전진
            int nx = robot.x + dx[robot.getLeft()];
            int ny = robot.y + dy[robot.getLeft()];
            if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                robot.x = nx;
                robot.y = ny;
                robot.dir = robot.getLeft();
                solution(robot);
            }
            if (count == 4) {
                int bx = robot.x + dx[robot.getBack()];
                int by = robot.y + dy[robot.getBack()];
                if (arr[bx][by] == 1) {
                    return;
                }
                robot.x = bx;
                robot.y = by;
                count = 0;
                continue;
            }
            if (arr[nx][ny] == 1 || visited[nx][ny]) {
                robot.dir = robot.getLeft();
                count++;
            }
        }



    }

    static public class Robot {
        int x;
        int y;
        int dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public int getLeft() {
            if (dir == 0) {
                return 3;
            } else if (dir == 1) {
                return 0;
            } else if (dir == 2) {
                return 1;
            } else if (dir == 3) {
                return 2;
            }
            return -1;
        }

        public int getBack() {
            if (dir == 0) {
                return 2;
            } else if (dir == 1) {
                return 3;
            } else if (dir == 2) {
                return 0;
            } else if (dir == 3) {
                return 1;
            }
            return -1;
        }
    }

}
