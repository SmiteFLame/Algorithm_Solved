package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val alpa = Array(26) { 0 }
    str.forEach { now ->
        alpa[now - 'A']++
    }
    var cnt = 0
    var center = 0
    for (i in 0 until 26) {
        if (alpa[i] % 2 == 1) {
            center = i
            cnt++
        }
    }
    if (cnt > 1 || (cnt == 1 && str.length % 2 == 0)) {
        println("I'm Sorry Hansoo")
        return
    }
    val sb = StringBuilder()
    for (i in 0..25){
        for (j in 0 until alpa[i] / 2){
            sb.append((i + 'A'.toInt()).toChar())
        }
    }
    val tmp = StringBuffer(sb.toString())
    if (cnt == 1){
        sb.append((center + 'A'.toInt()).toChar())
    }
    println(sb.toString() + tmp.reverse())
}
