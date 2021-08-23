package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var node = Array<Pair<Int, Int>>(8){ Pair(0, 0)}
    for(i in 0..7){
        node[i] = Pair(readLine().toInt(), i + 1)
    }
    node.sortByDescending { it.first }

    var answer = IntArray(5){ 0 }
    var sum = 0
    for(i in 0 until 5){
        sum += node[i].first
        answer[i] = node[i].second
    }
    println(sum)
    answer.sort()
    answer.forEach {
        it ->
        print("$it ")
    }
}