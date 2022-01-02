package programmers.level1.로또의최고순위와최저순위;

public class Solution {
    public static void main(String[] args) {
//        [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
        Integer[] lottos = {44, 1, 0, 0, 31, 25};
        Integer[] win_nums = {31, 10, 45, 1, 6, 19};

        int count = 0;
        int zeroCount = 0;
        for (Integer lotto : lottos) {
            for (Integer win_num : win_nums) {
                if (win_num.equals(lotto)) {
                    count++;
                }
            }
            if (lotto.equals(0)) {
                zeroCount++;
            }
        }

        int[] answer = {match(count + zeroCount), match(count)};
    }

    public static int match(int totalCount) {
        return switch (totalCount) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
