package programmers.level1.숫자문자열과영단어;

public class Solution2 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], String.valueOf(i));
        }

        System.out.println(s);
    }
}