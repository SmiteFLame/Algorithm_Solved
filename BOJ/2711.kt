package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        sb.append(st.nextToken().removeRange(n - 1, n) + "\n")
    }
    print(sb.toString())
}