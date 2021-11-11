package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        var n = st.nextToken().toDouble()
        while(st.hasMoreTokens()){
            when(st.nextToken()){
                "@" -> n *= 3
                "%" -> n += 5
                "#" -> n -= 7
            }
        }
        sb.append("${String.format("%.02f", n)}\n")
    }
    print(sb.toString())
}
