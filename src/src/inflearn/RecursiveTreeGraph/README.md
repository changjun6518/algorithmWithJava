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