#스택 큐

[올바른괄호](올바른괄호.java)
```
Stack<Character> stack = new Stack<>();
```
스택을 사용하는 문제! 간단한

[괄호문자제거](괄호문자제거.java)
```
stack.size();
stack.get();
```
간단한 아이디어 묻는 문제\
size와 get을 사용할 수 있음

[크레인인형뽑기](크레인인형뽑기.java)

카카오 문제였는데 경우의 수 몇개 하니 쉽게 풀 수 있었다..!
재밌네

[후위식연산](후위식연산.java)
```
Stack<Integer> stack = new Stack<>();
if (Character.isDigit(c)) {
    stack.push(c - '0');
}
```
어차피 연산자는 stack에 안들어가니 Integer로 해도 되었고\
숫자인 경우 Character.isDigit() 사용해서 조건문 걸 수 있었다..\
나는 Character로 스택을 만들어서 뻘짓을 한...

[쇠막대기](쇠막대기.java)

아이디어 싸움이였던 것 같은데... 쉽게 보이지 않앗다 피곤해서 그런가

[공주구하기](공주구하기.java)
```
LinkedList<Integer> queue = new LinkedList<>();
```
드뎌 queue를 사용\
사용법은 차차 사용하면서 익히자\
poll(), offer() 등등