import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int wanhoAtt = scores[0][0];
        int wanhoPeer = scores[0][1];     
        
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);   
        
        int k = scores[0][1];
        
        for(int[] score : scores){
            if(k > score[1]){
                if(wanhoAtt == score[0] && wanhoPeer == score[1]) {
                    answer = -1;
                    break;
                }
                score[0] = -1;
                score[1] = -1;
            }else{
                k = score[1];
            }
            
        }
        
        if(answer != -1){
            Arrays.sort(scores, (o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
            for(int i = 0; i < scores.length; i++){
                if(wanhoAtt == scores[i][0] && wanhoPeer == scores[i][1]){
                    answer = i + 1;
                    break;
                }
            }
        }
        return answer;
    }
}