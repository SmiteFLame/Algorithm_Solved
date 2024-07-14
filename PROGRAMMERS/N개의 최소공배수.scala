object Solution {
    def gcd(a: Int, b: Int): Int = {
        if(b == 0) a else gcd(b, a % b)
    }
    
    def lcm(a: Int, b: Int): Int = {
        (a * b).abs / gcd(a, b)
    }
    
    def solution(arr: Vector[Int]): Int = {
        arr.reduce(lcm)
    }
}