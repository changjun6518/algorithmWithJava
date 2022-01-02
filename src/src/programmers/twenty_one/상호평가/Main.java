package programmers.twenty_one.상호평가;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(5);
        temp.add(2);
        temp.add(7);
        temp.add(1);
        Collections.sort(temp);

        for (Integer integer : temp) {
            System.out.println(integer);
        }
        if (temp.contains(1)) {
            System.out.println("tlqks");
        }
    }
}
