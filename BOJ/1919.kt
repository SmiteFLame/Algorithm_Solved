package test

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val strA = readLine()
    val strB = readLine()

    val count = Array<Int>(26){0}
    strA.forEach { n ->
        count[n - 'a']++
    }
    strB.forEach { n ->
        count[n - 'a']--
    }
    var answer = 0
    count.forEach { n ->
        answer += abs(n)
    }
    print(answer)
}