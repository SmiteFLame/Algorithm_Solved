package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var map = HashMap<Int, Int>()
    var max = Pair(0, 0)
    repeat(readLine().toInt()){
        var n = readLine().toInt()
        map.putIfAbsent(n, 0)
        map.replace(n, map.getValue(n) + 1)
        if(map.getValue(n) > max.second){
            max = Pair(n, map.getValue(n))
        } else if(map.getValue(n) == max.second && n < max.first){
            max = Pair(n, map.getValue(n))
        }
    }
    println(max.first)
}