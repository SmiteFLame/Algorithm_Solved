import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap();
        for(int i = 0, end = s.length(); i < end; i++){
            Character now = s.charAt(i);
            if(map.containsKey(now)){
                answer[i] = i - map.get(now);
            } else{
                answer[i] = -1;
            }
            map.put(now, i);
        }
        return answer;
    }
}