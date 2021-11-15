package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    val sb = StringBuilder()
    if (a > b) {
        sb.append("${a - b - 1}\n")
        for (i in b + 1 until a) {
            sb.append("$i ")
        }
    }
    else if (b > a) {
        sb.append("${b - a - 1}\n")
        for (i in a + 1 until b) {
            sb.append("$i ")
        }
    }
    else if (a == b) {
        sb.append("0")
    }
    print(sb.toString())


}
