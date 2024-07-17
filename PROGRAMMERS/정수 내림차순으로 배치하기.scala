object Solution {
    def solution(n: Long): Long = {
        n.toString.sorted(Ordering.Char.reverse).mkString.toLong
    }
}