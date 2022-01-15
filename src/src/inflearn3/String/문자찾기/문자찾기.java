package inflearn3.String.문자찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String b = bufferedReader.readLine();
        char target = b.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            System.out.println(Character.toLowerCase(c));
            if (Character.toLowerCase(c) == target) {
                count++;
            }
        }
        System.out.println(count);

    }
}
