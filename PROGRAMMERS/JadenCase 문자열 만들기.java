import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0, end = strArray.length; i < end; i++) {
            if (strArray[i].length() == 0){
                sb.append(" ");
            } else {
                char first = strArray[i].charAt(0);
                char next = Character.toUpperCase(first);
                sb.append(next).append(strArray[i].substring(1).toLowerCase());
            
                if(i != end - 1){
                    sb.append(" ");
                }
            }
        }
        
        if(" ".equals(s.substring(s.length() - 1, s.length()))){
            sb.append(" ");
        }
        
        return sb.toString();
    }
}