import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(x, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            if(now == y){
                return map.get(now);
            }
            
            if(!map.containsKey(now + n) && now + n <= y){
                map.put(now + n, map.get(now) + 1);
                queue.add(now + n);
            }
            
            if(!map.containsKey(now * 2) && now * 2 <= y){
                map.put(now * 2, map.get(now) + 1);
                queue.add(now * 2);
            }
            
            if(!map.containsKey(now * 3) && now * 3 <= y){
                map.put(now * 3, map.get(now) + 1);
                queue.add(now * 3);
            }
        }
        return answer;
    }
}