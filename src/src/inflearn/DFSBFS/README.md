# DFS / BFS

[합이같은부분집합](합이같은부분집합.java)
```
public static void DFS(int[] arr, int sum, int level) {
    if (flag) {
        return;
    }
    if (level == numberCount) {
        if ((totalSum - sum) == sum) {
            answer = "YES";
            flag = true;
        }
    } else {
        DFS(arr, sum + arr[level], level + 1);
        DFS(arr, sum, level + 1);
    }
}
```
배열에 넣고 한칸씩 두갈래로 진행하는 DFS를 만들면 됨\
flag 넣어서 retrun하게끔 설계하고\
default로 answer에 NO 넣어두고 조건만족할때 YES로 바꿈

[바둑이승차](바둑이승차.java)
```
static public void DFS(int sum, int level) {
    if (limitWeight < sum) {
        return;
    }
    if (level == count) {
        answer = Math.max(sum, answer);
    }
    else {

        if (answer <= sum) {
            answer = sum;
        }
        DFS(sum + arr[level], level + 1);
        DFS(sum, level + 1);
    }
}
```
자잘한 조건들의 순서도 중요한 것 같다 \
조건 위치가 바뀌면 index 범위를 넘어선다

[최대점수구하기](최대점수구하기.java)
```
public static void DFS(int timeSum, int scoreSum, int level) {
    if (timeSum > timeLimit) {
        return;
    }
    if (problemCount == level) {
        answer = Math.max(scoreSum, answer);
    } else {
        DFS(timeSum + timeToSolve[level], scoreSum + scoreByProblem[level], level + 1);
        DFS(timeSum, scoreSum, level + 1);
    }
}
```
저 problemCount == level부분에 대한 이해가 필요 생각좀 (부분집합이 완성되는 조건)\
부분 집합이 완성 안되면 DFS로 계속 보내는 else코드를 보낼 수 있음 ( < 하면 else로 안넘어가서 안댐 )

[중복순열](중복순열.java)
```
public static void DFS(int level) {
    if (level == limitNum) {
        for (int i : purmutation) {
            System.out.print(i + " ");
        }
        System.out.println();
    } else {
        for (int i = 1; i <= totalCount; i++) {
            purmutation[level] = i;
            DFS(level + 1);
        }
    }
}
```
중복 순열 출력!\
음.. purmutation. level하는 부분에 대한 이해가 어려웠다\
level로 인덱스를 가르치면서 조건문을 거는 것!!

[동전교환](동전교환.java)
```
public static void DFS(int level, int sum) {
    if (sum > exchangeMoney) {
        return;
    }
    if (level >= answer) {
        return;
    }
    if (sum == exchangeMoney) {
        answer = Math.min(level, answer);
    } else {
        for (int i = 0; i < totalCount; i++) {
            DFS(level + 1, sum + coins[i]);
        }
    }
}
```
DFS로 해설했지만 BFS로 target금액만났을때 level을 답으로 하는 방법도 생각해볼것\
나도 이렇게 할까 했지만 실패..

[순열구하기](순열구하기.java)

음 간단히 생각하고 풀 수 있었음...! 설명만 읽고 코딩! check배열 사용

[조합수](조합수.java)
```
public static int DFS(int N, int R) {
    if (memory[N][R] > 0) {
        return memory[N][R];
    }
    if (N == R || R == 0) {
        return 1;
    } else {
        return memory[N][R] = DFS(N - 1, R - 1) + DFS(N - 1, R);
    }
}
```
쫄지마라 메모이제이션을 활요함!

[수열 추측하기](수열추측하기.java)

손으로 직접 그려보면서 해야할듯 머리로 안된다\
순열과 조합 두개로 푸는 문제!

[조합구하기](조합구하기.java)

간단하게 조합을 출력하는 문제!

[미로탐색](미로탐색.java)
```
public static void DFS(int x, int y) {
    if (x == 7 && y ==7) {
        answer++;
    } else {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (miro[nx][ny] == 0) {
                miro[nx][ny] = 1;
                DFS(nx, ny);
                miro[nx][ny] = 0;
            }
        }
    }
}
```
나는 미로배열을 벽까지 생각하여 +2를 해줬지만\
조건문에서 nx, ny를 범위에 만족하도록 설정할 수도 있음
[미로최단거리](미로최단거리.java)
```
public static void BFS(int x, int y) {
    LinkedList<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));
    while (!queue.isEmpty()) {
        Point currentPoint = queue.poll();
        for (int i = 0; i < 4; i++) {
            int nx = currentPoint.x + dx[i];
            int ny = currentPoint.y + dy[i];
            if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && miro[nx][ny] == 0) {
                queue.add(new Point(nx, ny));
                miro[nx][ny] = 1;
                dis[nx][ny] = dis[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}
```
DFS로도 풀 수 있지만 최단거리는 엥간하면 BFS로 풀자\
여기서는 한칸씩 나아가면서 걸어온 길이를 저장하는 배열(dis)을 통해 풀었음

[토마토](토마토.java)

bfs로 푸는 문제 접근 방식에 따라 약간의 차이가 있음\
가로 세로 입력받았을 때 세로를 먼저 for문 돌려야함!!\
인덱스 조심하고

[섬나라아일랜드](섬나라아일랜드.java)

이것도 인덱스 조심하구 밖에서 answer를 체크하는 문제였다