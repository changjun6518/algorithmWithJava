package inflearn2.String;

import java.util.Scanner;

public class 문자찾기 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String str = scanner.next().toLowerCase();

        String key = scanner.next().toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == key.charAt(0)) {
                count++;
            }
        }

        System.out.println(count);

    }
}
//Computercooler
//c