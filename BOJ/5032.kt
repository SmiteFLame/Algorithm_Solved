package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val e = st.nextToken().toInt()
    val f = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    var sum = e + f
    var answer = 0
    while(sum >= c){
        val next = sum / c
        answer += next
        sum = next + (sum % c)
    }
    print(answer)
}
