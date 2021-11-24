package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val t = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val p = st.nextToken().toInt()
    var cnt = 0
    var day = 1 + t
    
    while(day <= n){
        cnt += c
        day += t
    }
    
    print(cnt * p)
}
