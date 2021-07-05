package inflearn.문자열;

import java.util.ArrayList;
import java.util.Scanner;

public class 압축 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        String answer = "";
        for (int i = 0; i < num; i++) {
            String temp = str.substring(0,7).replace('#', '1').replace('*', '0');
            int number = Integer.parseInt(temp, 2);
            answer += (char) number;
            str = str.substring(7);
        }
        System.out.println(answer);

    }
}

//    public static void main(String[] args) {
////        4
////        #****###**#####**#####**##**
//
//        Scanner sc = new Scanner(System.in);
//        Integer num = Integer.valueOf(sc.next());
//        String str = sc.next();
//        char[] answer = new char[num];
//        StringBuilder sb = new StringBuilder();
//
//        for (int j = 0; j < num; j++) {
//            for (int i = 0; i < 7; i++) {
//                if (str.charAt(i) == '#') {
//                    sb.append("1");
//                } else {
//                    sb.append("0");
//                }
//            }
//            String s = sb.toString();
//            int intNum = Integer.parseInt(s, 2);
//
//            char charNum = (char) intNum;
//
//            answer[j] = charNum;
//            sb.delete(0, sb.length());
//            str = str.substring(7);
//        }
//
//        for (char c : answer) {
//            System.out.printf("%c", c);
//        }
//
//    }
