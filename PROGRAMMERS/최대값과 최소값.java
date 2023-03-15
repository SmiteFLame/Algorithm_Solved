import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while(st.hasMoreTokens()){
            int now = Integer.parseInt(st.nextToken());
            max = Math.max(now, max);
            min = Math.min(now, min);
        }
        
        return min + " " + max;
    }
}