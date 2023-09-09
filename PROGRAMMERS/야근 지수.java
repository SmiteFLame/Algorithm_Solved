import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int work: works){
            pQ.add(work);
        }
        while(!pQ.isEmpty() && n > 0){
            int now = pQ.poll();
            now -= 1;
            if(now > 0){
                pQ.add(now);
            }
            n--;
        }
        while(!pQ.isEmpty()){
            int now = pQ.poll();
            answer += (now * now);
        }
        
        return answer;
    }
}