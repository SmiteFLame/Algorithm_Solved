package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    fun gcd(a: Int, b: Int): Int{
        return if(b == 0) a
        else gcd(b, a % b)
    }
    val st = StringTokenizer(readLine(), ":")
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = if(n > m){
        gcd(n, m)
    } else{
        gcd(m, n)
    }
    print("${n/k}:${m/k}")
}
