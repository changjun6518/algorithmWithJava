package programmers.twenty_one.문자열압축;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
        
    }

    public static int solution(String s) {
        int result = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String[] divided = new String[s.length() / i];
            String temp = s.substring(s.length() - (s.length() % i) , s.length());
            String partAnswer = "";

            int dInx = 0;

            for (int j = 0; j < s.length(); j += i) {
                if (j + i <= s.length()) {
                    divided[dInx++] = s.substring(j, j + i);
                } else {
                    break;
                }
            }
            int count = 1;
            for (int k = 1; k < divided.length; k++) {
                if (divided[k - 1].equals(divided[k])) {
                    count++;
                } else {
                    if (count == 1) {
                        partAnswer += divided[k - 1];
                    } else {
                        partAnswer += count + divided[k - 1];
                        count = 1;
                    }
                }
                if (k == divided.length - 1) {
                    if (count == 1) {
                        partAnswer += divided[k - 1];

                    } else partAnswer += count + divided[k - 1];
                }
            }
            partAnswer += temp;
            if(result > partAnswer.length()) {
                result = partAnswer.length();
            }

        }
        return result;
    }
}
