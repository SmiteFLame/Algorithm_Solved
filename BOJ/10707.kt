package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var A = readLine().toInt()
    var B = readLine().toInt()
    var C = readLine().toInt()
    var D = readLine().toInt()
    var E = readLine().toInt()

    var X = E * A
    var Y = 0

    if(E <= C){
        Y = B
    } else{
        Y = B + (E - C) * D
    }
    if(X > Y) print(Y)
    else print(X)
}