package codingTest.Simulation.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] sea;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        BabyShark babyShark = null;

        sea = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    babyShark = new BabyShark(i, j);
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
        int x;
        int y;
        int size = 2;
        int countEatFish = 0;

        public BabyShark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int eat() {
            ArrayList<int[]> possibleFish = seekCanEatFish();
            sizeUp();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(sea[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            if (possibleFish.size() < 1) {
                return 0;
            } else if (possibleFish.size() == 1) {
                int[] location = possibleFish.get(0);
                int time = calculateDistance(location);
                update(location);
                return time;
            } else {
                int[] location = seekMinDistance(possibleFish);
                int time = calculateDistance(location);
                update(location);
                return time;
            }
        }

        private void update(int[] location) {
            x = location[0];
            y = location[1];
            sea[x][y] = 0;
        }

        private ArrayList<int[]> seekCanEatFish() {
            ArrayList<int[]> fish = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (sea[i][j] != 0 && sea[i][j] < size) {
                        fish.add(new int[]{i, j});
                    }
                }
            }
            return fish;
        }


        private int[] seekMinDistance(ArrayList<int[]> fish) {
            int min = Integer.MAX_VALUE;
            ArrayList<int[]> minDistanceFish = new ArrayList<>();

            for (int[] location : fish) {
                int distance = calculateDistance(location);
                if (min > distance) {
                    min = distance;
                }
            }
            for (int[] location : fish) {
                int distance = calculateDistance(location);
                if (min == distance) {
                    minDistanceFish.add(location);
                }
            }
            if (minDistanceFish.size() > 1) {
                return seekHighPriorityFish(minDistanceFish);
            }
            return minDistanceFish.get(0);
        }

        private int[] seekHighPriorityFish(ArrayList<int[]> fish) {
            int[] high = fish.get(0);

            for (int i = 1; i < fish.size(); i++) {
                int[] nowFish = fish.get(i);
                if (high[0] > nowFish[0]) {
                    high = nowFish;
                } else if (high[0] == nowFish[0]) {
                    if (high[1] > nowFish[1]) {
                        high = nowFish;
                    }
                }
            }

            return high;
        }

        private int calculateDistance(int[] location) {
            int time = 0;
            time += Math.abs(x - location[0]) + Math.abs(y - location[1]);
            return time;
        }

        private void sizeUp() {
            countEatFish++;
            if (countEatFish % size == 0) {
                size++;
                countEatFish = 0;
            }
        }
    }

}
