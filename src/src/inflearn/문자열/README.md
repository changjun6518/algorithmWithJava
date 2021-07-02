#문자열

[문자찾기](문자찾기.java)  
```
sc.next().charAt(index);
```
charAt(index)로 문자열하나 가져옴
```
str.toUpperCase();
Character.toUpperCase(char c);

for(char x : str.toCharArray()){}
```
문자열은 바로 함수, 문자는 character써서 해야함   
iter쓰고싶으면 str을 문자배열로 바꿔줘야함

[대소문자변환](대소문자변환.java)   
처음 접근 => 정규표현식으로 소문자인지 대문자인지 확인   
그리고 대소문자 변환해주는 함수 만들었음   
그리고 static 스프링 만들어서 추가해서 결과 만들려고함
```
Character.isLowerCase(c)
```
Charector에 소문자 대문자 인지 확인하는 함수가 있다..