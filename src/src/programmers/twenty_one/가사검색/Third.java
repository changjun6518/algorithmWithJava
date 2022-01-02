package programmers.twenty_one.가사검색;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //  음   words 길이 2~ 100000
        //  각 가사 단어의 길이 1~10000
        //  전체 가사 단어 길이의 합 2 ~ 1000000
        //  가사에 동일 단어 여러번이면 중복 제거 후 words에 하나로만 제공 -> 중복제거

        //  각 단어 오직 소문자로만 구성

        //  queries 길이 2~100000
        //  검색 키워드 길이 1~10000
        //  전체 합길이  2~1000000
        //  검색 키워드는 중복될 수 있음
        //  오직 소문자와 ? 로 구성
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] solution = solution(words, queries);

        System.out.println(Arrays.toString(solution));

    }
    public static int[] solution(String[] words, String[] queries) {
        Trie[] tries=new Trie[100001];
        for(String word:words) {
            int len=word.length();
            if(tries[len]==null) tries[len]=new Trie();
            tries[len].insert(word);
        }

        int[] answer=new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int len=queries[i].length();
            if(tries[len]==null) answer[i]=0;
            else answer[i]=tries[len].getCount(queries[i]);
        }
        return answer;
    }
}
class Trie{
    Node front, back;

    public Trie() {
        this.front=new Node();
        this.back=new Node();
    }
    public void insert(String word) {
        insertFront(word);
        insertBack(word);
    }
    private void insertFront(String word) {
        Node node=front;
        for(int i=0;i<word.length();i++) {
            node.count++;
            node=node.children.computeIfAbsent(word.charAt(i), c->new Node());
        }
    }
    private void insertBack(String word) {
        Node node=back;
        for(int i=word.length()-1;i>=0;i--) {
            node.count++;
            node=node.children.computeIfAbsent(word.charAt(i), c->new Node());
        }
    }
    public int getCount(String query) {
        if(query.charAt(0)=='?') return getCountFromBack(query);
        else return getCountFromFront(query);
    }
    private int getCountFromFront(String query) {
        Node node=front;
        for(int i=0;i<query.length();i++) {
            if(query.charAt(i)=='?') break;
            if(!node.children.containsKey(query.charAt(i))) return 0;
            node=node.children.get(query.charAt(i));
        }
        return node.count;
    }
    private int getCountFromBack(String query) {
        Node node=back;
        for(int i=query.length()-1;i>=0;i--) {
            if(query.charAt(i)=='?') break;
            if(!node.children.containsKey(query.charAt(i))) return 0;
            node=node.children.get(query.charAt(i));
        }
        return node.count;
    }
}
class Node{
    HashMap<Character, Node> children;
    int count;

    public Node(){
        this.children=new HashMap<>();
        this.count=0;
    }
}
