package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val data = Array(n){0}
    val st = StringTokenizer(readLine())
    for(i in 0 until n){
        data[i] = st.nextToken().toInt()
    }

    var answer = 0
    for(i in 0 until n){
        for(j in i + 1 until n){
            if(data[i] + data[j] == m){
                answer++
                break
            }
        }
    }
    print(answer)
}
