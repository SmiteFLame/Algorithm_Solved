object Solution {
    def solution(n: Int): Int = {
        val mod = 1234567
        if(n < 2) n
        else {
            var a = 0
            var b = 1
            var result = 0
            for(_ <- 2 to n) {
                result = (a + b) % mod
                a = b
                b = result
            }
            result
        }
    }
}