package programmers.level2.타겟넘버;

public class Solution2 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        BFS bfs = new BFS(target, numbers);
        bfs.calculate(0, 0);
        int answer = bfs.getAnswer();
        System.out.println(answer);
    }
}

class BFS {
    int answer = 0;
    int target;
    int[] numbers;

    public BFS(int target, int[] numbers) {
        this.target = target;
        this.numbers = numbers;
    }

    public int getAnswer() {
        return answer;
    }

    public void calculate(int level, int sum) {
        if (numbers.length == level) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        calculate(level + 1, sum + numbers[level]);
        calculate(level + 1, sum - numbers[level]);
    }
}
