### dynamic programming

[계단오르기](계단오르기.java)

큰 것을 작은 것으로 쪼개서 풀어나간다 (피보나치)

[돌다리건너기](돌다리건너기.java)

한 칸 더 가야하는 것을 고려하는 문제 (작은 함정)

[최대부분증가수열](최대부분증가수열.java)

문제만 이해하면 괜찮았음!

[가장높은탑쌓기](가장높은탑쌓기.java)
```
public static int solution(ArrayList<block> blocks) {
    Collections.sort(blocks);
    int answer = 0;

    dy[0] = blocks.get(0).height;
    answer = dy[0];
    for (int i = 1; i < blocks.size(); i++) {
        int max = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (blocks.get(i).weight < blocks.get(j).weight && max < dy[j]) {
                max = dy[j];
            }
            dy[i] = max + blocks.get(i).height;
            answer = Math.max(dy[i], answer);
        }
    }
    return answer;
}
```
조건이 2개이면 한 조건으로 정렬하고\
다른 조건은 LIS방법으로 조건 확인하고 그 위에 올리는 느낌으로 접근한다

[동전교환냅색](동전교환냅색.java)
```
public static int solution(int[] coins) {
    Arrays.fill(dy, Integer.MAX_VALUE);
    dy[0] = 0;
    for (int i = 0; i < n; i++) {
        for (int j = coins[i]; j < m + 1; j++) {
            dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
        }
    }
    return dy[m];
}
```
dy[]는 해당 인덱스 가격의 동전 최소 동전 개수 저장배열이라고 생각하고\
인덱스에서 coin을 뺀 곳에서 1을 더하면 해당 인덱스 최소 동전 개수이다

[최대점수구하기냅색](최대점수구하기냅색.java)
```
public static int solution(ArrayList<problem> problems) {
    Collections.sort(problems);
    dy[0] = 0;
    for (int i = 0; i < n; i++) {
        problem problem = problems.get(i);
        for (int j = m; j >= problem.time; j--) {
            dy[j] = Math.max(dy[j], dy[j - problem.time] + problem.score);
        }
    }
    return dy[m];
}
```
나는 j를 증가하는 식으로 했지만 그렇게 되면 문제를 2번 푸는 중복이 발생한다\
j를 거꾸로 내려오는 식으로 하면 중복을 막을 수 있었음...간단하지만 생각하기 쉽지않음