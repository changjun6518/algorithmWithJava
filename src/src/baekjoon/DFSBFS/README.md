# DFS/BFS

[영역구하기](./영역구하기/Main.java)

dfs/bfs 로 푸는 문제<br>
음...반복 숙달 접근 방법!!<br>
x y 정확하게 생각해서 적용해라

[단지번호붙이기](./단지번호붙이기/Main.java)

charAt하면 ascii로 되니 주의하길 바람

[암호만들기](./암호만들기/Main.java)

1. 방문여부 체크하고
2. if(cnt==level) 체크해서
3. 만족하면 조건 확인해서 출력!

[알파벳](./알파벳/Main.java)

방문여부 체크할때 ArrayList로 체크했는데 시간이 오래걸린다\
그래서 음 visited 배열로 인덱스를 visited[arr[x][y]-'A']로 체크해서 시간을 줄였다