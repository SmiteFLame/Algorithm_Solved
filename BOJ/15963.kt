package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    if(st.nextToken().toLong() == st.nextToken().toLong()){
        print(1)
    } else{
        print(0)
    }
}
