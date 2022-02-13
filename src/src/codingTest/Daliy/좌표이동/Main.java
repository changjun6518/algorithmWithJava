package codingTest.Daliy.좌표이동;

import java.util.*;

public class Main {
    static int[] y = new int[100001];
    static int[] x = new int[100001];

    public static String[] solution(int[][] rectangles) {

        ArrayList<Rectangle> rectangleList = new ArrayList<>();
        HashMap<Integer, Rectangle> orders = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        int index = 0;
        for (int[] rectangle : rectangles) {
            Rectangle rec = new Rectangle(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
            orders.put(index++, rec);
            rectangleList.add(rec);
        }

        rectangleList.sort(yPriorityCompare);
        for (int i = 0; i < rectangles.length; i++) {
            Rectangle rectangle = rectangleList.get(i);
            rectangle.updateHeight();
        }

        rectangleList.sort(xPriorityCompare);
        for (int i = 0; i < rectangles.length; i++) {
            Rectangle rectangle = rectangleList.get(i);
            rectangle.updateWidth();
        }

        for (int i = 0; i < rectangles.length; i++) {
            answer.add(orders.get(i).toString());
        }

        return answer.toArray(new String[rectangles.length]);
    }

    private static final Comparator<Rectangle> yPriorityCompare = Comparator.comparingInt(o -> o.y1);
    private static final Comparator<Rectangle> xPriorityCompare = Comparator.comparingInt(o -> o.x1);


    private static class Rectangle {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public void updateHeight() {
            int maxValue = returnMaxValueInXRange();
            int dif = maxValue - y1;
            y1 += dif;
            y2 += dif;

            for (int i = x1; i < x2; i++) {
                x[i] = y2;
            }
        }

        private int returnMaxValueInXRange() {
            int maxValue = 0;
            for (int i = x1; i < x2; i++) {
                maxValue = Math.max(maxValue, x[i]);
            }
            return maxValue;
        }

        public void updateWidth() {
            int maxValue = returnMaxValueInYRange();
            int dif = maxValue - x1;
            x1 += dif;
            x2 += dif;

            for (int i = y1; i < y2; i++) {
                y[i] = x2;
            }
        }

        private int returnMaxValueInYRange() {
            int maxValue = 0;
            for (int i = y1; i < y2; i++) {
                maxValue = Math.max(maxValue, y[i]);
            }
            return maxValue;
        }

        @Override
        public String toString() {
            return x1 + " " + y1 + " " + x2 + " " + y2;
        }
    }

    public static void main(String[] args) {
        int[][] rectangles = {
                {0, 2, 1, 3},
                {1, 2, 2, 5},
                {3, 3, 4, 4},
                {4, 1, 6, 3},
                {1, 6, 5, 7},
                {5, 5, 7, 6},
                {5, 8, 6, 10}
        };

        String[] answer = solution(rectangles);
        System.out.println(Arrays.toString(answer));

    }
}
