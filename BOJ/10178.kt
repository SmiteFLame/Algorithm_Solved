package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val c = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        sb.append("You get ${c/v} piece(s) and your dad gets ${c%v} piece(s).\n")
    }
    print(sb.toString())
}
