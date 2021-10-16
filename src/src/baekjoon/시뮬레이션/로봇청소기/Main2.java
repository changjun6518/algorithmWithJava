package baekjoon.시뮬레이션.로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int N;
    static int M;
    static int[][] arr;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        String[] split = br.readLine().split(" ");
        Robot robot = new Robot(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(split1[j]);
            }
        }

        solution(robot);

        System.out.println(count);

    }

    public static void solution(Robot robot) {

        // 1. 현재 위치를 청소한다


        while (arr[robot.upDown][robot.leftRight] != 1) {

            if (arr[robot.upDown][robot.leftRight] == 0) {
                arr[robot.upDown][robot.leftRight] = 2;
                count++;
            }
            // 2. 현재위치에서 현재방향을 기준으로 왼쪽 빵향부터 차례대로 인접한 칸을 탐색
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                // 현재 방향 기준 왼쪽 방향 구하기
                int nx = robot.upDown + dx[robot.getLeftDir()];
                int ny = robot.leftRight + dy[robot.getLeftDir()];

                // a. 진행
                if (arr[nx][ny] == 0) {
                    robot.dir = robot.getLeftDir();
                    robot.upDown = nx;
                    robot.leftRight = ny;
                    flag = true;
                    break;  // 4방향 탐색 빠져나오기
                }

                // b. 진행  청소할 공간이 없다면인데 위 조건만 아니면 청소가 아니므로 회전
                robot.dir = robot.getLeftDir();
            }
            if (flag) {
                continue;
            }

            // c. 모두 체크한 경우 방향 유지한채 한칸후진하고 2번으로?
            int nx = robot.upDown + dx[robot.getBackDir()];
            int ny = robot.leftRight + dy[robot.getBackDir()];

            // d. 벽이라 후진 할 수 없으면 작동 멈춘다
            if (arr[nx][ny] == 1) {
                break;
            }
            robot.upDown = nx;
            robot.leftRight = ny;

        }

    }


    private static class Robot {
        int upDown;
        int leftRight;
        int dir;

        public Robot(int upDown, int leftRight, int dir) {
            this.upDown = upDown;
            this.leftRight = leftRight;
            this.dir = dir;
        }

        public int getLeftDir() {
            if (dir == 0) {
                return 3;
            } else if (dir == 1) {
                return 0;
            } else if (dir == 2) {
                return 1;
            } else if (dir == 3) {
                return 2;
            }
            System.out.println("에러야~에러~");
            return -1;
        }

        public int getBackDir() {
            if (dir == 0) {
                return 2;
            } else if (dir == 1) {
                return 3;
            } else if (dir == 2) {
                return 0;
            } else if (dir == 3) {
                return 1;
            }
            System.out.println("에러야~에러~22");
            return -1;
        }


    }
}

