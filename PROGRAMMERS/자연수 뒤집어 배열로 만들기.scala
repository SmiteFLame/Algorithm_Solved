object Solution {
    def solution(n: Long): Vector[Int] = {
        n.toString.reverse.map(_.asDigit).toVector
    }
}