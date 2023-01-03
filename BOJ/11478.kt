package test

import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val set = HashSet<String>()
    for(i in str.indices){
        var now = ""
        for(j in i until str.length){
            now += str[j]
            set.add(now)
        }
    }
    println(set.size)
}
