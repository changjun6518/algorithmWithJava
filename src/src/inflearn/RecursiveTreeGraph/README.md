# 재귀 트리 그래프 (dfs, bfs) 기초

[재귀함수](재귀함수.java)
```
public static void recursive(int num) {
    if (num == 0) {
        return;
    } else {
        recursive(num - 1);
        System.out.print(num+ " ");
    }
}
```
저 print문을 재귀하기 전에 넣느냐 뒤에 넣느냐에 따라 출력이 달라짐...!

[이진수출력](이진수출력.java)

조금만 생각하면 풀 수 있음

[팩토리얼](팩토리얼.java)

제발... 간단한 아이디어일 뿐 지금 너무 조급한가

[피보나치수열](피보나치수열.java)
```
public static int bfs(int num) {
        if (fibo[num] > 0) {
            return fibo[num];
        }
        if (num == 1 || num == 2) {
            return fibo[num] = 1;
        } else {
            return fibo[num] = bfs(num - 1) + bfs(num - 2);
        }

    }
```
배열을 만들어서 저장해 나가면 된다!\
근데 배열에 값이 있다면 바로 리턴하게해서 (미리 저장된 값을 리턴함)\
반복수행을 제거함 (메모이제이션)

[이진트리순회](이진트리순회.java)
```
public static void preorder(Node node) {
        System.out.print(node.data + " ");
        if (node.lt != null) {
            preorder(node.lt);
        }
        if (node.rt != null) {
            preorder(node.rt);
        }
    }
```
오랜만에 이진트리순회 전위,후위, 중위에 대해 코딩해보았다..!

[부분집합구하기](부분집합구하기.java)
```
public static void DFS(int L) {
        if (L == num + 1) {
            for (int i = 1; i <= num; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            arr[L] = 1;
            DFS(L+1);
            arr[L] = 0;
            DFS(L+1);
        }
    }
```
음 배열을 사용해서 BFS로 푸는 문제였다 \
해설을 안보면 잘 모를 거 같다..이제 배웠으니 할 수 있겠죠

[이진트리레벨탐색](이진트리레벨탐색.java)
```
public static void BFS(Node node) {
    LinkedList<Node> queue = new LinkedList<>();
    queue.offer(node);
    int level = 1;
    while (!queue.isEmpty()) {
        int len = queue.size();
        System.out.print(level + "level : ");
        for (int i = 0; i < len; i++) {
            Node poll = queue.poll();
            System.out.print(poll.data + " ");
            if (poll.lt != null) {
                queue.offer(poll.lt);
            }
            if (poll.rt != null) {
                queue.offer(poll.rt);
            }
        }
        level++;
        System.out.println();
    }
}
```
queue를 사용해서 bfs 구현!

[송아지찾기](송아지찾기.java)
```
public int BFS(int s, int e) {
    ch = new int[10001];
    ch[s] = 1;
    queue.offer(s);
    int L = 0;
    while (!queue.isEmpty()) {
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            Integer x = queue.poll();
            if (x == e) {
                return L;
            }
            for (int j = 0; j < 3; j++) {
                int nx = x + dis[j];
                if (nx > 1 && nx < 10001 && ch[nx] == 0) {
                    ch[nx] = 1;
                    queue.offer(nx);
                }
            }
        }
        L++;
    }
    return 0;
}
```
설명없이 혼자 못하겠다 풀다보면 적응되고 할 수 있지 않을까? 아직 처음이니깐

[tree말단노드까최소경로DFS](tree말단노드까최소경로DFS.java)
```
public static int DFS(int L, Node node) {
    if (node.rt == null && node.lt == null) {
        return L;
    } else {
        return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
    }
}
```
두갈래로 해서 최소값을 받겠다 (두갈래아니면 에러)\
