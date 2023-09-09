import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> rankingByPlayer = new HashMap<>();
        Map<Integer, String> rankingByNumber = new TreeMap<>();
        
        for(int i = 1, end = players.length; i <= end; i++) {
            rankingByPlayer.put(players[i - 1], i);
            rankingByNumber.put(i, players[i - 1]);
        }
        
        for(int i = 0, end = callings.length; i < end; i++) {
            String calledPlayer = callings[i];
            Integer calledPlayerRanked = rankingByPlayer.get(calledPlayer);
            Integer overedPlayerRanked = calledPlayerRanked - 1;
            String overedPlayer = rankingByNumber.get(calledPlayerRanked - 1);
            
            rankingByPlayer.put(calledPlayer, overedPlayerRanked);
            rankingByPlayer.put(overedPlayer, calledPlayerRanked);
            
            rankingByNumber.put(overedPlayerRanked, calledPlayer);
            rankingByNumber.put(calledPlayerRanked, overedPlayer);
        }
        return rankingByNumber.values().toArray(new String[0]);
    }
}