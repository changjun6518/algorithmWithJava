package inflearn.StackQueue;

import java.util.LinkedList;
import java.util.Scanner;

public class 교육과정설계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        CBA
//CBDAGE

        String necessarySubject = sc.next();
        String inputSubject = sc.next();

        LinkedList<Character> necessarySubjectGroup = new LinkedList<>();
        LinkedList<Character> inputSubjectGroup = new LinkedList<>();

        for (char c : necessarySubject.toCharArray()) {
            necessarySubjectGroup.offer(c);
        }
        for (char c : inputSubject.toCharArray()) {
            inputSubjectGroup.offer(c);
        }

        while (!inputSubjectGroup.isEmpty()) {
            Character poll = inputSubjectGroup.poll();
            if (poll == necessarySubjectGroup.peekFirst()) {
                necessarySubjectGroup.poll();
            }
        }

        if (necessarySubjectGroup.isEmpty()) {
            System.out.println("YES");
        }else System.out.println("NO");
    }
}
