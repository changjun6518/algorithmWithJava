package programmers.level1.숫자문자열과영단어;

public class Solution {
    public static void main(String[] args) {
        String s = "one4seveneight";
        // 1478
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");

        System.out.println("s = " + s);
    }
}