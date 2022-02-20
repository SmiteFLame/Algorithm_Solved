package test

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
 
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val array = Array(n) { 0 }
    st = StringTokenizer(readLine())
    for (i in 0 until n) {
        array[i] = abs(s - st.nextToken().toInt())
    }

    var answer = array[0]
    for (i in 1 until n) {
        answer = gcd(answer, array[i])
    }
    print(answer)
}
