object Solution {
    def solution(s: String): Int = {
        val n = s.length
        if (n == 0) 0
        else {
            val dp = Array.ofDim[Boolean](n, n)
            for(i <- 0 until n) dp(i)(i) = true
            
            var maxLength = 1
            
            for(i <- 0 until n - 1) {
                if(s(i) == s(i + 1)) {
                    dp(i)(i+1) = true
                    maxLength = 2
                }
            }
            for(k <- 3 to n) {
                for(i <- 0 until n - k + 1) {
                    val j = i + k - 1
                    if(dp(i + 1)(j - 1) && s(i) == s(j)) {
                        dp(i)(j) = true
                        if(k > maxLength) { 
                            maxLength = k
                        }
                    }
                }
            }
            maxLength
        }
    }
}