package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    var a = st.nextToken().toLong()
    var b = st.nextToken().toLong()
    if(b > a){
        val temp = a
        a = b
        b = temp
    }
    val answer : Long = (a + b) * (a - b + 1) / 2
    print(answer)
}