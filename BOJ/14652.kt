package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    var cnt = 0
    for(i in 0 until n){
        for(j in 0 until m){
            if(cnt == k){
                print("$i $j")
                return
            }
            cnt++
        }
    }
}