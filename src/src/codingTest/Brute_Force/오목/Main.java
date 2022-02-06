package codingTest.Brute_Force.오목;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[][] map = new int[19][19];
    static boolean[][][] visited = new boolean[19][19][4];
    static int count;
    static PriorityQueue<Location> priorityQueue = new PriorityQueue<>();
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    if (check(new Location(i, j))) {
                        System.out.println(map[i][j]);
                        Location peek = priorityQueue.peek();
                        System.out.println((peek.x + 1) + " " + (peek.y + 1));
                        return;
                    }
                }
            }
        }
        System.out.println("0");
    }

    public static boolean check(Location location) {
        for (int i = 0; i < 4; i++) {
            count = 1;
            priorityQueue.clear();
            priorityQueue.add(location);
            if (!visited[location.x][location.y][i]) {
                visited[location.x][location.y][i] = true;
                checkNext(location, i);
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void checkNext(Location location, int direction) {
        int nx = location.x + dx[direction];
        int ny = location.y + dy[direction];

        if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19) {
            return;
        }

        if (map[nx][ny] != map[location.x][location.y]) {
            return;
        }

        if (visited[nx][ny][direction]) {
            return;
        }

        count++;
        Location nextLocation = new Location(nx, ny);
        priorityQueue.add(nextLocation);
        visited[nx][ny][direction] = true;
        checkNext(nextLocation, direction);
    }


    private static class Location implements Comparable<Location> {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o) {
            if (this.y == o.y) {
                return this.x - o.x;
            } else return this.y - o.y;
        }
    }
}
//- 완전 탐색하면서 1과 2인 곳부터 연속 5알인지 체크하는 함수 실행
//- 연속 5알인지 체크 함수는 좌표가 넘어오면 8가지 방향으로 자신과 같은 바둑알인지 for문 한번 돈다 (count 초기화하고)
//    - 같은 바둑알이면 그 방향으로 계속 나아간다 (count++)
//    - 그리고 우선순위 큐에 바둑알들 위치를 다 넣는다
//- count가 5이면 해당 바둑알 1 or 2 출력하고 우선순위 큐 제일 윗 값을 출력
