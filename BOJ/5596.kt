package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var S = 0
    repeat(4){
        S += st.nextToken().toInt()
    }
    st = StringTokenizer(readLine())
    var T = 0
    repeat(4){
        T += st.nextToken().toInt()
    }
    if(S > T) print(S)
    else print(T)
}
