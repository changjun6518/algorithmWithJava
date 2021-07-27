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