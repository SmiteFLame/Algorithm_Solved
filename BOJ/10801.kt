package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val st1 = StringTokenizer(readLine())
    val st2 = StringTokenizer(readLine())
    var count = 0
    for(i in 0 until 10){
        val a = st1.nextToken().toInt()
        var b = st2.nextToken().toInt()
        if(a > b) count++
        else if(a < b) count--
    }
    if(count > 0){
        print("A")
    } else if(count < 0){
        print("B")
    } else{
        print("D")
    }
}
