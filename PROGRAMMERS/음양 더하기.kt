class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer = 0
        for(i in 0 until absolutes.size) {
            answer += (if(signs[i]) 1 else -1) * absolutes[i] 
        }
        return answer
    }
}