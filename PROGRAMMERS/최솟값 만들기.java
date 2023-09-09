import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0, end = A.length; i < end; i++) {
            answer += (A[i] * B[end - 1 - i]);
        }
        
        return answer;
    }
}