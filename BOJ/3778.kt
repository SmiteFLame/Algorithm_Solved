package test

import java.lang.StringBuilder
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    for(i in 1..n){
        val str1 = readLine()
        val str2 = readLine()
        val map = HashMap<Char, Int>()
        var answer = 0
        str1.forEach { now ->
            map.putIfAbsent(now, 0)
            map[now] = map[now]!! + 1
        }
        str2.forEach { now ->
            map.putIfAbsent(now, 0)
            map[now] = map[now]!! - 1
        }
        map.forEach{ (_, i) ->
            answer += abs(i)
        }
        sb.append("Case #$i: $answer\n")
    }
    print(sb.toString())
}
