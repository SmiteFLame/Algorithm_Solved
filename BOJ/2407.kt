package test

import java.math.BigInteger
import java.util.*



fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    var A = BigInteger.ONE
    var B = BigInteger.ONE
    for(i in 0 until M){
        A = A.multiply(BigInteger((N - i).toString()))
        B = B.multiply(BigInteger((i + 1).toString()))
    }
    println(A.divide(B))
}