package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken()
    val m = st.nextToken()
    var answer = 0L
    n.forEach { nn ->
        m.forEach { mm ->
            answer += (nn.toInt() - '0'.toInt()) * (mm.toInt() - '0'.toInt())
        }
    }
    print(answer)
}
