package programmers.level2.타겟넘버;

public class Solution {
    static int N;
    static int R;
    static boolean[] visited;
    static int[] numbers;
    static int count = 0;
    static int target;
    public static void main(String[] args) {
        numbers = new int[]{1, 1, 1, 1, 1};
//        numbers = new int[]{1, 2, 3, 4, 5};
        target = 3;

        // 조합으로 풀 것 같고
        // 어 조합의 구성도 반복문 돌리면서
        N = numbers.length;

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            R = i;
            DFS(0, 0);
        }
    }

    public static void DFS(int level, int start) {
        if (level == R) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            if (sum == target) {
                count++;
            }
        } else {
            for (int i = start; i < N; i++) {
                visited[i] = true;
                DFS(level + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
