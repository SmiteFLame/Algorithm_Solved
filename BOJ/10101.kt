package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var a = readLine().toInt()
    var b = readLine().toInt()
    var c = readLine().toInt()
    if(a + b + c != 180) println("Error")
    else if(a == b && b == c) println("Equilateral")
    else if(a == b || b == c || a == c) println("Isosceles")
    else println("Scalene")
}