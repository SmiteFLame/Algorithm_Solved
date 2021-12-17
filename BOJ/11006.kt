package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val x = m * 2 - n
        sb.append("$x ${m - x}\n")
    }
    print(sb.toString())
}
