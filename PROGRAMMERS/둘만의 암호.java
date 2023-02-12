import java.util.*;

class Solution {
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> skipSet = new HashSet<Character>();
        
        for(int i = 0, end = skip.length(); i < end; i++){
            skipSet.add(skip.charAt(i));
        }
        
        for(int i = 0, end = s.length(); i < end; i++){
            char now = s.charAt(i);
            for(int j = 0; j < index; j++){
                now++;
                if(now == 'z' + 1){
                    now = 'a';
                }
                while(skipSet.contains(now)){
                    now++;
                    if(now == 'z' + 1){
                        now = 'a';
                    }
                }
            }
            answer += now;
        }        
        return answer;
    }
}