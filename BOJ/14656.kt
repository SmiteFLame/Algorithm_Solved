package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 0
    val st = StringTokenizer(readLine())
    for(i in 1..n){
        if(st.nextToken().toInt() != i){
            answer++
        }
    }
    print(answer)
}
