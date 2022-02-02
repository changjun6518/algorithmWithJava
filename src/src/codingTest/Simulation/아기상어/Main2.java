package codingTest.Simulation.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int[][] sea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];
        BabyShark babyShark = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    babyShark = new BabyShark(new Location(i, j, 0));
                    sea[i][j] = 0;
                }
            }
        }
        int totalTime = 0;
        int time;
        do {
            time = babyShark.eat();
            totalTime += time;
        } while (time != 0);

        System.out.println(totalTime);

    }

    private static class BabyShark {
        int size = 2;
        Location location;
        int countEatFish = 0;

        public BabyShark(Location location) {
            this.location = location;
        }

        public int eat() {
            ArrayList<Location> minDistanceFish = new ArrayList<>();
            LinkedList<Location> Q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            visited[location.x][location.y] = true;
            Q.add(location);


            int len;
            while (!Q.isEmpty()) {
                len = Q.size();
                for (int i = 0; i < len; i++) {
                    Location baby = Q.pop();
                    for (int j = 0; j < 4; j++) {
                        int nx = baby.x + dx[j];
                        int ny = baby.y + dy[j];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue;
                        }
                        if (visited[nx][ny] || sea[nx][ny] > size) {
                            continue;
                        }

                        Location nextFish = new Location(nx, ny, baby.count + 1);
                        Q.add(nextFish);
                        visited[nx][ny] = true;
                        if (sea[nx][ny] != 0 && sea[nx][ny] != size) {
                            minDistanceFish.add(nextFish);
                        }
                    }

                }


                if (minDistanceFish.size() == 1) {
                    sizeUp();
                    int time = minDistanceFish.get(0).count;
                    update(minDistanceFish.get(0));
                    return time;
                } else if (minDistanceFish.size() > 1) {
                    sizeUp();
                    int time = seekMinDistanceFish(minDistanceFish).count;
                    update(seekMinDistanceFish(minDistanceFish));
                    return time;
                }

            }
            return 0;
        }

        private Location seekMinDistanceFish(ArrayList<Location> fish) {
            int min = Integer.MAX_VALUE;
            for (Location fishLocation : fish) {
                min = Math.min(min, fishLocation.count);
            }

            PriorityQueue<Location> priorityQueue = new PriorityQueue<>();
            for (Location fishLocation : fish) {
                if (min == fishLocation.count) {
                    priorityQueue.add(fishLocation);
                }
            }

            return priorityQueue.poll();
        }

        private void update(Location nextLocation) {
            location.x = nextLocation.x;
            location.y = nextLocation.y;
            sea[location.x][location.y] = 0;
        }

        private void sizeUp() {
            countEatFish++;
            if (countEatFish % size == 0) {
                size++;
                countEatFish = 0;
            }
        }
    }

    private static class Location implements Comparable<Location> {
        int x;
        int y;
        int count;

        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }


        @Override
        public int compareTo(Location o) {
            if (x < o.x) {
                return -1;
            } else if (x == o.x) {
                return y < o.y ? -1 :1;
            }
            return 1;
        }
    }

}
