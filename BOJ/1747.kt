package test

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt() - 1
    next@
    while (true) {
        n++
        if (n == 1) continue@next
        for (i in 2..sqrt(n.toFloat()).toInt()) {
            if (n % i == 0) {
                continue@next
            }
        }
        val str = n.toString()
        for(i in 0..(str.length/2)){
            if(str[i] != str[str.length - i - 1]){
                continue@next
            }
        }
        break
    }
    print(n)
}
