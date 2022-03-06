package codingTest.Daliy.소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Student[] students = new Student[25];
    static Student[] combi = new Student[7];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                students[index++] = new Student(i, j, line.charAt(j));
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int level, int start) {
        if (level == 7) {
            if (check(combi)) {
                answer++;
            }
        } else {
            for (int i = start; i < 25; i++) {
                combi[level] = students[i];
                dfs(level + 1, i + 1);
            }
        }
    }

    private static boolean check(Student[] combi) {
        return isAdjacent(combi) && isOverFour(combi);
    }

    private static boolean isOverFour(Student[] combi) {
        int count = 0;
        for (Student student : combi) {
            if (student.name == 'S') {
                count++;
            }
        }
        return count >= 4;
    }

    private static boolean isAdjacent(Student[] combi) {
        List<Student> list = Arrays.asList(combi);
        LinkedList<Student> Q = new LinkedList<>();
        boolean[][] visited = new boolean[25][25];
        Student first = list.get(0);
        Q.add(first);
        visited[first.x][first.y] = true;
        int count = 1;

        while (!Q.isEmpty()) {
            Student now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                Student adj = new Student(nx, ny, 'T');
                if (nx<0||ny<0||nx>=5||ny>=5||visited[nx][ny]) {
                    continue;
                }
                if (!list.contains(adj)) continue;

                visited[nx][ny] = true;
                count++;
                Q.add(adj);
            }
        }
        return count == 7;
    }

    private static class Student{
        int x;
        int y;
        char name;

        public Student(int x, int y, char name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return x == student.x && y == student.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
