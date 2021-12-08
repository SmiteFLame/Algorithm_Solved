package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while(true){
        val str = readLine()
        if(str == "#") break
        var answer = 0
        str.toLowerCase().forEach { now ->
            if(now in listOf('a', 'e', 'o', 'i', 'u')){
                answer++
            }
        }
        sb.append("$answer\n")
    }
    print(sb.toString())
}
