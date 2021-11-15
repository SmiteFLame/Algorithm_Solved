package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        sb.append("Case ${it + 1}: ${st.nextToken().toInt() + st.nextToken().toInt()}\n")
    }
    print(sb.toString())
}
