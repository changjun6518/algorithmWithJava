# 스택 덱

[괄호](./괄호/Main.java)

쉬운 스택을 이용한 문제였음

[쇠막대기](./쇠막대기/Main.java)

이전 인덱스를 확인하면 되는데 그게 떠오르지가 않았음<br>
단순하게 처음은 무조건 '(' 니까 i=1부터시작해서 하면되는데

[크게만들기](./크게만들기/Main.java)

1. 처음엔 조합으로 풀었음
2. 스택으로 조금만 생각하면 풀 수 있었음
3. 마음이 조급하니 잘 안보임...

[문자열폭발](문자열폭발/Main2.java)

1. 스택으로 풀 수 있음
2. 넣다가 bomb의 길이를 넘어서면 bomb이랑 같은지 체크
3. 같으면 stack이면 pop해주고 배열이면 index를 조절해줌

[히스토그램](히스토그램/Main.java)

1. 분할정복으로 반씩 나눠서 넓이 구하고 다시 반나눠서 넓이 구하는 방식
2. 중간지점의 넓이도 확인해야함 (1,2번 케이스를 계속 확인하면서 줄여나가고 max를 찾는 방식)

[탑](탑/Main.java)

1. 스택 아이디어로 푸는 문제이지만 오랜만인지 어려움
2. 메모리 초과로 통과하지 못했는데 scanner를 사용하지 않으니까 통과가 됐다 왜지?

[덱](덱/Main.java)

1. deque에 관해 다뤄보는 시간 앞뒤로 푸시와 poll 이 가능하다
2. scanner로 받으니까 시간 초과가 뜨고 버퍼로 받으니 안뜨네 다뤄봐야겠다

[검열](검열/Main.java)

1. Q를 두개 만들어서 (stack도 가능함) 앞 뒤로 문자 받고 key 있으면 poll 하고
2. 끝나면 다시 뭉쳐서 있는지 확인하고 빼주고 끝!