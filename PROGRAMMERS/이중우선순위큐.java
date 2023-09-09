import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        PriorityQueue<Integer> pQasc = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pQdesc = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0, end = operations.length; i < end; i++) {
            st = new StringTokenizer(operations[i]);
            String oper = st.nextToken();
            Integer number = Integer.parseInt(st.nextToken());
            if(oper.equals("I")) {
                pQasc.add(number);
                pQdesc.add(number);
            } else if(number == 1) {
                if(pQdesc.size() > 0){
                    Integer now = pQdesc.poll();
                    pQasc.remove(now);
                }
            } else {
                if(pQasc.size() > 0){
                    Integer now = pQasc.poll();
                    pQdesc.remove(now);
                }
            }
        }
        
        
        int[] answer = new int[2];
        if(pQasc.size() > 0){
            answer[0] = pQdesc.poll();   
            answer[1] = pQasc.poll(); 
        }
        return answer;
    }
}