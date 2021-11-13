package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(3) {
        val st = StringTokenizer(readLine())
        var h = st.nextToken().toInt()
        var m = st.nextToken().toInt()
        var s = st.nextToken().toInt()
        h = st.nextToken().toInt() - h
        m = st.nextToken().toInt() - m
        s = st.nextToken().toInt() - s
        if(s < 0){
            s+=60
            m--
        }
        if(m < 0){
            m += 60
            h--
        }
        println("$h $m $s")
    }

}
