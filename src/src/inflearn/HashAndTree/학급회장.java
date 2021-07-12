package inflearn.HashAndTree;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        A, B, C, D, E


//15
//BACBACCACCBDEDE

        int n = sc.nextInt();
        HashMap<Character, Integer> classPresident = new HashMap<>();

        classPresident.put('A', 0);
        classPresident.put('B', 0);
        classPresident.put('C', 0);
        classPresident.put('D', 0);
        classPresident.put('E', 0);

        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = classPresident.get(c);
            classPresident.put(c, ++count);
        }
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (Character c : classPresident.keySet()) {
            if (max < classPresident.get(c)) {
                max = classPresident.get(c);
                answer = c;
            }
        }

        System.out.println(answer);

    }


}
