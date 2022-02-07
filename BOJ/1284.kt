package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while(true){
        val s = readLine()
        if(s == "0") break
        var answer = 1
        s.forEach { now ->
            answer += when (now) {
                '0' -> 5
                '1' -> 3
                else -> 4
            }
        }
        sb.append("$answer\n")
    }
    print(sb.toString())
}
