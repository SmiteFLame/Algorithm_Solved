class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if(common[2] - common[1] == common[1] - common[0]){
            return common[common.length - 1] + common[1] - common[0];
        } 
        return common[common.length - 1] * (common[1] / common[0]);
    }
}