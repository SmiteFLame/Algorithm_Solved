package test

import java.lang.StringBuilder
import java.math.BigInteger

val sb = StringBuilder()

fun hanoi(n: Int, num: Int, from: Int, by: Int, to: Int){
    if(num == n - 1){
        sb.append("$from $to\n")
        return
    }
    hanoi(n, num + 1, from, to, by)
    sb.append("$from $to\n")
    hanoi(n, num + 1, by, from, to)
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val big = BigInteger("2").pow(n).minus(BigInteger.ONE)
    sb.append("$big\n")
    if(n <= 20){
        hanoi(n, 0, 1, 2, 3)
    }
    print(sb.toString())
}
