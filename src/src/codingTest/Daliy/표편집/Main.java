package codingTest.Daliy.표편집;

import java.util.Stack;

public class Main {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> removedIndex = new Stack<>();
        int totalSize = n;
        int index = k;
        for(int i = 0; i < cmd.length; i++){
            char c = cmd[i].charAt(0);
            if(c == 'D'){
                index += Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'U'){
                index -= Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'C'){
                removedIndex.add(index);
                totalSize--;
                if(totalSize == index){
                    index--;
                }
            }else if(c == 'Z'){
                if(removedIndex.pop() <= index){
                    index++;
                }
                totalSize++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<totalSize;i++){
            sb.append('O');
        }
        while(!removedIndex.isEmpty()){
            sb.insert(removedIndex.pop(), "X");
        }
        return sb.toString();
    }
}
