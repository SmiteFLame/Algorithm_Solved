class Solution {
    fun solution(a: Int, b: Int): Long {
        var sum = 0L
        val min = minOf(a, b)
        val max = maxOf(a, b)
        for (i in min..max) {
            sum += i
        }
        return sum
    }
}