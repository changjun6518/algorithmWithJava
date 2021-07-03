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

[문장속단어](문장속단어.java)
```
String 메소드
indexof()
subString()
```
띄어쓰기 만나는 지점의 인덱스를 알아내고 그 인덱스로부터   
subString을 통해 잘라내면서 길이 파악     

[단어뒤집기](단어뒤집기.java)
```
String[] arr = new String[N];
String temp = new StringBuilder(s).reverse().toString();
char[] s = str.toCharArray();
```
String[] 초기화는 위 처럼..   
String은 한번 만들면 불변하기 때문에 변경할 경우 계속해서 새로운 객체를 생성\
StringBuilder는 변경가능하기때문에 스트링보다 가볍다 메모리 적게 쓰니까!\
이거 말구 문자를 toCharArray써서 인덱스 맨처음이랑 끝이랑 바꾸면서 하는 것도 방법!