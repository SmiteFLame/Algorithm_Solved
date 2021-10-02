package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    val top = Array<Int>(h + 1) { 0 }
    val bot = Array<Int>(h + 1) { 0 }

    for(i in 0 until n / 2){
        bot[readLine().toInt()]++
        top[readLine().toInt()]++
    }

    for(i in 1..h){
        bot[i] += bot[i - 1]
        top[i] += top[i - 1]
    }

    var answer = n
    var cnt = 0
    for(i in 1..h){
        var now = 0
        now += bot[h] - bot[i - 1]
        now += top[h] - top[h - i]

        if(answer > now){
            answer = now
            cnt = 1
        } else if(answer == now){
            cnt++
        }
    }
    print("$answer $cnt")
}