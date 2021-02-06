package SmiteFLame.BOJ_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    static int answer;
    static Stack<Pair> scoreStack = new Stack<>();
    static Stack<Character> checkStack = new Stack<>();
    static String S;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));

    static class Pair{
        int score;
        int level;
        Pair(int score, int level){
            this.score = score;
            this.level = level;
        }
    }
    public static void init() throws IOException {
        S = io.readLine();
    }

    public static void inputStack(int score, int level){
        // 전에 있던 항목들 확인
        while(!scoreStack.isEmpty()){
            if(scoreStack.peek().level < level) break;
            else if(scoreStack.peek().level == level){
                score += scoreStack.pop().score;
            } else{
                score *= scoreStack.pop().score;
            }
        }
        scoreStack.add(new Pair(score, level));
    }

    public static boolean implement() {
        int level = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(' || S.charAt(i) == '['){
                checkStack.add(S.charAt(i));
                level++;
            } else{
                if(checkStack.isEmpty()){
                    return false;
                }else if(S.charAt(i) == ')' && checkStack.pop() == '('){
                    inputStack(2, level);
                }else if(S.charAt(i) == ']' && checkStack.pop() == '['){
                    inputStack(3, level);
                }else{
                    return false;
                }
                level--;
            }
        }
        return checkStack.isEmpty() ? true : false;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(implement() ? scoreStack.pop().score : 0);
    }
}
