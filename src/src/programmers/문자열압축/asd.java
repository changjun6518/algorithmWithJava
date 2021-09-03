package programmers.문자열압축;

import java.util.Scanner;

public class asd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));

    }
    public static int solution(String s) {
        int result = s.length();
        for(int i = 1; i <= s.length() / 2; i++) {
            String[] divided = new String[s.length() / i];                            //나뉜 문자열을 담을 배열
            String temp = s.substring(s.length() - (s.length() % i) , s.length());     //나머지 문자열
            String partAnswer = "";

            int dInx = 0;

            for(int j = 0; j < s.length(); j += i) {                                //나눈 배열, s.legnth()/i까지로 해서 반복횟수를 정해도 된다.
                if(j + i <= s.length()) {
                    divided[dInx++] = s.substring(j, j+i);
                }else {
                    break;
                }
            }
            int count = 1;
            for(int k = 1; k < divided.length; k++) {                                //문장을 완성하는 반복문
                if(divided[k-1].equals(divided[k])) {
                    count++;
                }else {
                    if(count == 1) {
                        partAnswer += divided[k - 1];
                    }else {
                        partAnswer += count + divided[k - 1];
                        count=1;
                    }
                }
                if(k == divided.length - 1) {                                        //종료시 마지막 문장을 추가
                    if(count == 1) {
                        partAnswer += divided[k-1];
                    }else {
                        partAnswer += count+divided[k-1];
                    }
                }
            }

            partAnswer += temp;                                                        //나머지 문장을 추가
            if(result > partAnswer.length()) {
                result = partAnswer.length();
            }

        }
        return result;
    }
}
