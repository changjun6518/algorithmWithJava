package inflearn2.String;

import java.util.Scanner;

public class 문장속단어 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int count = 0;
        String answer = "";
        for (String s : str) {
            if (s.length() > count) {
                count = s.length();
                answer = s;
            }
        }

        System.out.println(answer);
    }
}
//it is time to study