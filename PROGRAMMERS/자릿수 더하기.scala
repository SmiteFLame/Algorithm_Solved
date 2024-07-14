object Solution {
    def solution(n: Int): Int = {
        n.toString.map(_.asDigit).sum
    }
}