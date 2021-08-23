package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var now = 0
    var max = 0
    repeat(10) {
        var st = StringTokenizer(readLine())
        var down = st.nextToken().toInt()
        var up = st.nextToken().toInt()
        now = now - down + up
        if(now > max){
            max = now
        }
    }
    println(max)
}