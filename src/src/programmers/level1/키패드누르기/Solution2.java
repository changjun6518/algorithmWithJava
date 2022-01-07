package programmers.level1.키패드누르기;

public class Solution2 {
    static int[][] phonePosition = {
            {1, 0},
            {0, 3},
            {1, 3},
            {2, 3},
            {0, 2},
            {1, 2},
            {2, 2},
            {0, 1},
            {1, 1},
            {2, 1},
    };

    static int[] leftThumb = {0, 0};
    static int[] rightThumb = {2, 0};

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        for (int number : numbers) {
            answer += calculateHand(number, hand);
        }

        return answer;
    }

    public static String calculateHand(int number, String hand) {
        switch (number) {
            case 1: case 4: case 7:
                leftThumb = phonePosition[number];
                return "L";
            case 3: case 6: case 9:
                rightThumb = phonePosition[number];
                return "R";
        }
        return getCloseHand(number, hand);
    }

    private static String getCloseHand(int number, String hand) {
        if (isCloserLeft(number)) {
            leftThumb = phonePosition[number];
            return "L";
        }
        if (isCloserRight(number)) {
            rightThumb = phonePosition[number];
            return "R";
        }
        return getMainHand(number, hand);
    }

    private static String  getMainHand(int number, String hand) {
        if (hand.equals("right")) {
            rightThumb = phonePosition[number];
            return "R";
        }
        leftThumb = phonePosition[number];
        return "L";
    }

    private static boolean isCloserLeft(int number) {
        return getDistanceBy(number, leftThumb) < getDistanceBy(number, rightThumb);
    }

    private static boolean isCloserRight(int number) {
        return getDistanceBy(number, leftThumb) > getDistanceBy(number, rightThumb);
    }

    private static int getDistanceBy(int number, int[] handPosition) {
        return Math.abs(phonePosition[number][0] - handPosition[0]) + Math.abs(phonePosition[number][1] - handPosition[1]);
    }



    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = "LRLLLRLLRRL";
        System.out.println(solution(numbers, hand));
        String solution = solution(numbers, hand);

        System.out.println(answer.equals(solution));

    }
}