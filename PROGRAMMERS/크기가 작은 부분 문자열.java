class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long info = Long.parseLong(p);
        for(int i = 0, end = t.length() - p.length(); i <= end; i++){
            long now = Long.parseLong(t.substring(i, i + p.length()));
            if(now <= info){
                answer++;
            }
        }
        return answer;
    }
}