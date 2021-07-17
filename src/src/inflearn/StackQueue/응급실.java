package inflearn.StackQueue;

import java.util.LinkedList;
import java.util.Scanner;

public class 응급실 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        5 2
//60 50 70 80 90

        int patientNum = sc.nextInt();
        int patientIndex = sc.nextInt();
        int count = 0;
        LinkedList<Person> people = new LinkedList<>();

        for (int i = 0; i < patientNum; i++) {
            people.offer(new Person(i, sc.nextInt()));
        }

        while (!people.isEmpty()) {
            Person poll = people.poll();
            for (Person person : people) {
                if (person.priority > poll.priority) {
                    people.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                count++;
                if (poll.id == patientIndex) {
                    System.out.println(count);
                    return;
                }
            }

        }
    }
}

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

