package inflearn3.String.중복문자제거;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        ArrayList<Character> arr = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!arr.contains(c)) {
                arr.add(c);
            }
        }

        String collect = arr.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(collect);
    }
}
