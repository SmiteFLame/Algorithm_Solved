package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val tree = TreeMap<String, Int>()
    var count = 0
    while(true){
        val str = readLine() ?: break
        tree[str] =  tree.getOrDefault(str, 0) + 1
        count++
    }
    val sb = StringBuilder()
    tree.forEach{ (key, value) ->
        sb.append("$key ${String.format("%.4f", value.toDouble() * 100 / count)}\n")
    }
    print(sb.toString())
}
