package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val a = Array(3){0}
    val b = Array(3){0}
    val st1 = StringTokenizer(readLine())
    val st2 = StringTokenizer(readLine())
    repeat(3){
        a[it] = st1.nextToken().toInt()
        b[it] = st2.nextToken().toInt()
    }
    print("${b[0] - a[2]} ${b[1] / a[1]} ${b[2] - a[0]}")
}
