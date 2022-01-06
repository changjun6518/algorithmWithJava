package programmers.level1.키패드누르기;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] dx = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 2};
        int[] dy = {0, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0};
        int[] recentlyLocation = {10, 11};

        String hand = "right";
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                recentlyLocation[0] = number;
            }
            if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                recentlyLocation[1] = number;
            }
            if (number == 2 || number == 5 || number == 8 || number == 0) {
                int leftDistance = Math.abs(dx[number] - dx[recentlyLocation[0]]) + Math.abs(dy[number] - dy[recentlyLocation[0]]);
                int rightDistance = Math.abs(dx[number] - dx[recentlyLocation[1]]) + Math.abs(dy[number] - dy[recentlyLocation[1]]);
                if (leftDistance < rightDistance) {
                    sb.append("L");
                    recentlyLocation[0] = number;
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    recentlyLocation[1] = number;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        recentlyLocation[0] = number;
                    } else {
                        sb.append("R");
                        recentlyLocation[1] = number;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }


}
