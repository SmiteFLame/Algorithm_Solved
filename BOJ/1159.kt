package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var map = TreeMap<Char, Int>()
    repeat(readLine().toInt()){
        var c = readLine()[0]
        map.putIfAbsent(c, 0)
        map.replace(c, map.getValue(c) + 1)
    }
    var answer = ""
    map.forEach{
        (k, v) ->
        if(v >= 5){
            answer += k
        }
    }
    if(answer == "") print("PREDAJA")
    print(answer)
}