package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    fun GCD(a: Int, b: Int): Int{
        return if(b == 0) a
        else GCD(b, a % b)
    }
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val gcd = GCD(x.coerceAtLeast(y), x.coerceAtMost(y))
        sb.append("${x * y / gcd} $gcd\n")
    }
    print(sb.toString())
}
